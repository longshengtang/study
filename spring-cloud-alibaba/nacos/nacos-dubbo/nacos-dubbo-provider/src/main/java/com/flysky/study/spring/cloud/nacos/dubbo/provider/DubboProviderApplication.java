package com.flysky.study.spring.cloud.nacos.dubbo.provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RestController
public class DubboProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProviderApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
