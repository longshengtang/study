//package com.flysky.study.mybatis;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.flysky.study.mybatis.mapper.SysUserMapper;
//import com.flysky.study.mybatis.model.SysUser;
//import com.flysky.study.mybatis.serivce.SysUserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MyBatisTest {
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//    @Test
//    public void testMapperAnnotationSql(){
//        List<SysUser> sysUsers = sysUserMapper.test();
//        System.out.println(JSONObject.toJSONString(sysUsers));
//    }
//    @Test
//    public void testMapperSelectById(){
//        List<SysUser> sysUsers = sysUserMapper.selectList(null);
//        System.out.println(JSONObject.toJSONString(sysUsers));
//    }
//
//    @Test
//    public void getUsers() {
//        Assert.assertNotNull(sysUserService);
//        List<SysUser> sysUsers = sysUserService.selectList(null);
//        System.out.println(JSONObject.toJSONString(sysUsers) + "-----");
//    }
//    @Test
//    public void saveUser() {
//        SysUser user=new SysUser();
//        user.setName("autoIncrement");
//        sysUserService.insert(user);
//
//        System.out.println(JSONObject.toJSONString(user));
//    }
//
//}
