package com.flysky.study.springweb.controller;

//import com.flysky.study.mybatis.model.SysUser;

import net.bytebuddy.agent.ByteBuddyAgent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("getSysUserById")
    public String getSysUserById() {
//        String attach = System.mapLibraryName("attach");
//        System.out.println("Thread.currentThread().isAlive2() = " + Thread.currentThread().isAlive()+",attach="+attach);
        ByteBuddyAgent.install();
        return "sysUser-"+new Date();
    }

    @Value("${status:2")
    private String status = "1";

}
