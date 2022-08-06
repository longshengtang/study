package com.flysky.study.mybatis.xml;

import com.flysky.study.mybatis.mapper.SysUserMapper;
import com.flysky.study.mybatis.model.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MyBatisSourceTest {

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
}
