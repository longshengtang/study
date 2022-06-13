package com.flysky.study.springweb.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service("userService")
public class UserServiceImpl extends User{
    public void add() {
        System.out.println("新增用户");
    }

    public void delete() {
        System.out.println("删除用户");
    }

    public void update() {
        System.out.println("更新用户");
    }

    public void find() {
        System.out.println("查询用户");
    }


    private int a=3;
    private String str = "abc";
}
