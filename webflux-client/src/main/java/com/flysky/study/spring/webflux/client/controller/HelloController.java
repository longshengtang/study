package com.flysky.study.spring.webflux.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/")
@Slf4j
public class HelloController {
    @GetMapping("mono")
    public Mono<String> mono() {
        Mono<String> result = WebClient.create().get().uri("http://localhost:5005/api/mono")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class);
        return result;
//        return Mono.create(monoSink -> {
//            log.info("创建 Mono");
//            monoSink.success("hello webflux");
//        })
//                .doOnSubscribe(subscription -> { //当订阅者去订阅发布者的时候，该方法会调用
//                    log.info("{}", subscription);
//                }).doOnNext(o -> { //当订阅者收到数据时，改方法会调用
//                    log.info("{}", o);
//                });
    }

    @GetMapping("flux")
    public Flux<String> flux() {
        return Flux.just("hello","webflux","spring","boot").delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("str")
    public Mono<String> str() {
        Mono<String> result = WebClient.create().get().uri("http://localhost:5005/api/mono")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class);
        return result;
    }



    @Autowired
    private WebClient.Builder webclient;
}