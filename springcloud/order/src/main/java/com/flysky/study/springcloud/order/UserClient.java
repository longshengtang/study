package com.flysky.study.springcloud.order;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user")
public interface UserClient {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String hello();

    @RequestMapping("/u")
    Object user();
}
