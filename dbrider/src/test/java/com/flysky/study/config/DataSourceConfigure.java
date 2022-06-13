package com.flysky.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfigure {

    @Bean(name = "ds-h2")
    @Profile("h2")
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    public DataSource h2DataSource() {
        log.info("初始化h2DataSource");
        return h2DataSource;
    }

    @Bean(name = "ds-mysql")
    @Profile("mysql")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        log.info("初始化mysqlDataSource");
        return mysqlDataSource;//这样可以保证没有用到mysql的bean就不需要连接mysql数据库
    }

    private static final DriverManagerDataSource mysqlDataSource = new DriverManagerDataSource();
    private static final DriverManagerDataSource h2DataSource = new DriverManagerDataSource();
}
