package com.flysky.study.mybatis.xml;

import com.flysky.study.mybatis.mapper.SysUserMapper;
import com.flysky.study.mybatis.model.SysUser;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.mockito.Mockito;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyBatisSourceTest {

    @Test
    public void t() throws NoSuchFieldException, IllegalAccessException {
        BaseStatementHandler a = Mockito.mock(BaseStatementHandler.class);
        System.out.println("A.class.getFields() = " + A.class.getFields().length);
        System.out.println("A.class.getFields(h) = " + A.class.getDeclaredField("h"));
        System.out.println("BaseStatementHandler.class.getFields().length = " + BaseStatementHandler.class.getFields().length);
        System.out.println("BaseStatementHandler.class.getDeclaredField(\"configuration\") = " + BaseStatementHandler.class.getDeclaredField("configuration"));

//        Field h = A.class.getDeclaredField("h");
//        System.out.println("h = " + h);
//        boolean accessible = h.isAccessible();
//        h.setAccessible(true);
//        Object o = h.get(a);
//        System.out.println("o = " + o);
//        h.setAccessible(accessible);
    }

    class A{
       private final MyBatisSourceTest h=new MyBatisSourceTest();
    }
    /**
     * 从xml中创建factory
     * @throws IOException
     */
    @Test
    public void test_build_factory_from_xml() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        assertThat(sysUserMapper).isNotNull();


        SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
        //每次获取到的mapper都不一样，即使是同一个session
        assertThat(sysUserMapper).isNotEqualTo(mapper);

        SysUser sysUser = sysUserMapper.selectById(1L);
        sysUserMapper.selectById(2L);
        //即使不同Mapper，只要session相同，那么相同参数会命中一级缓存
        SysUser sysUser1 = mapper.selectById(1L);
        System.out.println("sysUser==sysUser1 = " + (sysUser == sysUser1)+"---id="+sysUser1.getId());
        sysUser1.setId(8l);
        mapper.insert(sysUser1);

        System.out.println("sysUser1.getId() = " + sysUser1.getId());

        mapper.deleteById(4l);
    }
    /**
     * 测试批量插入不提交不能获取主键id
     * @throws IOException
     */
    @Test
    public void test_batch_un_commit() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);


        SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);

        SysUser m = new SysUser();
        m.setTestId(1);
        m.setName("in");
        m.setUserName("u");
        mapper.insert(m);
        assertThat(m.getId()).isNull();
        sqlSession.commit();
        assertThat(m.getId()).isNotNull();

        System.out.println("m.getId() = " + m.getId());
    }
    /**
     * 获取生成的主键
     * @throws IOException
     */
    @Test
    public void test_simple_executor_commit() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);


        SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);

        SysUser m = new SysUser();
        m.setTestId(1);
        m.setName("in");
        m.setUserName("u");
        assertThat(m.getId()).isNull();
        mapper.insert(m);
        assertThat(m.getId()).isNotNull();

        System.out.println("m.getId() = " + m.getId());
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

    @Test
    public void test_get_connection_from_PooledDataSource() throws SQLException {

        String url="jdbc:mysql://10.1.1.11:3306/flysky";
        String username="root";
        String password="123456";
        String driver="com.mysql.cj.jdbc.Driver";
        PooledDataSource pooledDataSource = new PooledDataSource(driver,url,username,password);
        Connection connection = pooledDataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from sys_user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("resultSet.getObject(1) = " + resultSet.getObject(1));
        }

    }
}
