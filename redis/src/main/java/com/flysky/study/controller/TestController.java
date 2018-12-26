package com.flysky.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {

    @Autowired
    private StringRedisTemplate template;

    @GetMapping("test")
    public Object test(){
        template.opsForHash().get("a","a");
        return null;
    }
}
