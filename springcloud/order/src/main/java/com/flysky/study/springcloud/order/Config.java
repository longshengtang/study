package com.flysky.study.springcloud.order;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    @LoadBalanced//必须有，不然通过服务名称从eureka获取服务会报错。
    // 有此注解之后，非服务名称都不能使用了！！！
    // 需要使用域名的地址，直接new一个吧
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
