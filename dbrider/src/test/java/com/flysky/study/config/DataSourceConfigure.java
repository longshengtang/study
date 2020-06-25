package com.flysky.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfigure {
    @Bean(name = "ds-h2")
    @Profile("h2")
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    public DataSource dataSourceH2() {
        return new DriverManagerDataSource();
    }

    @Bean(name = "ds-mysql")
    @Profile("mysql")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource dataSourceMySql() {
        return new DriverManagerDataSource();
    }
}