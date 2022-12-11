package com.flysky.study.springcloud.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @RequestMapping("/u")
    public User user() {
        return new User("user",3,"男");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
