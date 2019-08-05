package com.flysky.study.dbunit;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.flysky.study.mybatis.mapper"})
@SpringBootApplication
public class DbunitApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbunitApplication.class,args);
    }
}
