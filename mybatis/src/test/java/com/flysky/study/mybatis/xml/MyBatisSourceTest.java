package com.flysky.study.mybatis.xml;

import com.flysky.study.mybatis.mapper.SysUserMapper;
import com.flysky.study.mybatis.model.SysUser;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MyBatisSourceTest {

    /**
     * 从xml中创建factory
     * @throws IOException
     */
    @Test
    public void test_build_factory_from_xml() throws IOException {
//        String resource = "org/mybatis/example/mybatis-config.xml";
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        assertThat(sysUserMapper).isNotNull();

        SysUser sysUser = sysUserMapper.selectById(1L);
    }

    /**
     * 只从java的api方式创建factory
     * @throws IOException
     */
    @Test
    public void test_build_factory_from_java() throws IOException {
        DataSource dataSource = new UnpooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql://10.1.1.11:3306/flysky","root","123456");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        configuration.addMapper(SysUserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        assertThat(sysUserMapper).isNotNull();

        SysUser sysUser = sysUserMapper.selectById(1L);
    }

    /**
     * 从java中创建factory，并在factory创建之前，给config增加xml文件的解析；这个方式做到了，优先加载java中的MappedStatement，然后再加载xml中的MappedStatement
     * @throws IOException
     */
    @Test
    public void test_build_factory_from_java_and_xml() throws IOException {
        DataSource dataSource = new UnpooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql://10.1.1.11:3306/flysky","root","123456");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        //加载同目录下同名称的xml文件，并且解析接口中注解所对应的test一个MappedStatement
        configuration.addMapper(SysUserMapper.class);

        //给api方式即在config中增加解析一个xml文件
        String resource = "mapper/SysUserMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
        mapperParser.parse();


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        assertThat(sysUserMapper).isNotNull();

        SysUser sysUser = sysUserMapper.selectById(1L);
    }
}
