package com.flysky.study.validation.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class Config {
    @Bean
    public MethodValidationPostProcessor getMethodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
