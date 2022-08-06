//package com.flysky.study.spring.cloud.alibaba.nacos.client;
//
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class RestConfig {
//
//    /**
//     * 官方推荐使用Builder构造创建对象
//     * 使@LoadBalanced用开启负载均衡的功能
//     *
//     * @param restTemplateBuilder
//     * @return
//     */
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
//        return restTemplateBuilder.build();
//    }
//}
