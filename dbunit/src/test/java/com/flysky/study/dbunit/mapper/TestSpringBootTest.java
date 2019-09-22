package com.flysky.study.dbunit.mapper;

import com.flysky.study.dbunit.MyValue;
import com.flysky.study.dbunit.config.TransactionalDevTestConfig;
import com.flysky.study.mybatis.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
//@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@SpringBootTest
@TransactionalDevTestConfig
//@EnableSpringConfigured
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
@EnableSpringConfigured
public class TestSpringBootTest {
    @Test
    public void test() {
        System.out.println(test);
//        System.out.println(mapper.selectById(1L));
        System.out.println(new EntityIoC().get());
        System.out.println("======="+System.getProperties().toString());
    }

    @Value("${mytest.abc}")
    private String test;

    @MyValue("${mytest.abc}")
    private String test2;
    @Autowired
    private SysUserMapper mapper;

    @Configuration
//    @ImportResource("org/springframework/beans/factory/aspectj/beanConfigurerTests-beans.xml")
    @EnableSpringConfigured
    static class Config {
    }
}
