package com.flysky.study.springweb.controller;

import com.flysky.study.mybatis.model.SysUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("getSysUserById")
    public SysUser getSysUserById(@RequestBody SysUser sysUser) {
        return sysUser;
    }
}
