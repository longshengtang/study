package com.flysky.study.config;

import com.flysky.study.mybatis.mapper.SysUserMapper;
import com.github.database.rider.core.api.configuration.DBUnit;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles(profiles = {"dev","mysql"})
//@DBRider(dataSourceBeanName = "ds-mysql")
@DBUnit(allowEmptyFields = true, caseSensitiveTableNames = true)
@MapperScan(basePackageClasses = {SysUserMapper.class})
@ContextConfiguration(classes = {
        DataSourceConfigure.class,
        DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class
        , DataSourceTransactionManagerAutoConfiguration.class
})
@Transactional
public @interface TransactionalDevTestConfigMysql { }