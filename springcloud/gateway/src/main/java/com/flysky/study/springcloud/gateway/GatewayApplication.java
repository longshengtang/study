package com.flysky.study.springcloud.gateway;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).web(WebApplicationType.REACTIVE).run(args);
//        SpringApplication.run(GatewayApplication.class, args);

    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder,UriConfiguration uriConfiguration) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org:80"))
                        .uri(uriConfiguration.getHttpbin()))
                .route("user_service",p -> p.path("/user/**")
                        //在将请求发送到下游之前，去掉前缀的两种方式
                        //方式1：使用正则替换
//                        .filters(f -> f.rewritePath("/user/(?<segment>.*)", "/${segment}").addRequestHeader("Hello", "User"))
                        //方式2：使用stripPrefix //参数为去掉几个路径，当前去掉一个路径//而prefixPath则添加前缀
                        .filters(f -> f.stripPrefix(1).addRequestHeader("Hello", "User"))
//                        .uri("http://httpbin.org:80"))
                        .uri("lb://user"))
                .route("order_service",p -> p.path("/order/**")
                        .filters(f -> f.rewritePath("/order/(?<segment>.*)", "/${segment}").addRequestHeader("Hello", "Order"))
//                        .uri("http://httpbin.org:80"))
                        .uri("lb://order"))
                .route(p -> p
                        .host("*.circuitbreaker.com")
                        .filters(f -> f.circuitBreaker(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")
                                )
                        )
//                        .uri("http://httpbin.org:80")
//                        .uri("https://www.baidu.com")
                        .uri(uriConfiguration.getHttpbin())
                )

                .route("remote_addr", r -> r.remoteAddr("192.168.1.1/24","10.1.1.1/24","localhost","127.0.0.1","0:0:0:0:0:0:0:1")
                        .filters(f -> f.addResponseHeader("Hi","Flysky").addRequestHeader("Hello", "localhost"))
                        .uri(uriConfiguration.getHttpbin()))
                .build();
//        return builder.routes()
//                .route("path_route", r -> r.path("/get")
//                        .uri("http://httpbin.org"))
//                .route("host_route", r -> r.host("*.myhost.org")
//                        .uri("http://httpbin.org"))
//                .route("rewrite_route", r -> r.host("*.rewrite.org")
//                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
//                        .uri("http://httpbin.org"))
//                .route("hystrix_route", r -> r.host("*.hystrix.org")
//                        .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
//                        .uri("http://httpbin.org"))
//                .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
//                        .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
//                        .uri("http://httpbin.org"))
//                .route("limit_route", r -> r
//                        .host("*.limited.org").and().path("/anything/**")
//                        .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
//                        .uri("http://httpbin.org"))
//                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback22\n");
    }

}

@Configuration
@ConfigurationProperties(value = "test")
class UriConfiguration {

    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}
