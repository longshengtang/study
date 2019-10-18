package com.flysky.study.dbunit;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = {"com.flysky.study.mybatis.mapper"})
@SpringBootApplication
@Configuration
public class DbunitApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbunitApplication.class,args);
    }

    @Bean
    public MyStandardBeanExpressionResolver getMyStandardBeanExpressionResolver() {
        return new MyStandardBeanExpressionResolver();
    }
}
