package com.flysky.study.validation.jdk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class Config {
    @Bean
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
