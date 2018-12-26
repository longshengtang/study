package com.flysky.study.mybatis.controller;


import com.flysky.study.mybatis.mapper.SysUserMapper;
import com.flysky.study.mybatis.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("test")
    public Object test() {
        System.out.println("fsjdfa;f");
        SysUser/**/ sysUser = sysUserMapper.selectById(1L);
        System.out.println(sysUser.getId() + " 333 " + sysUser.getName());
        return sysUser;
    }
}
