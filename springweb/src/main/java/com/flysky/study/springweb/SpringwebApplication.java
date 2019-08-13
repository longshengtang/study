package com.flysky.study.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringwebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringwebApplication.class);
    }
}