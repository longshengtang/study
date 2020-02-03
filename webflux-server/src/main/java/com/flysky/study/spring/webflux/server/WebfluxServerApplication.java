package com.flysky.study.spring.webflux.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebfluxServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebfluxServerApplication.class, args);
    }
}
