package com.flysky.study.mybatis.controller;


import com.flysky.study.mybatis.mapper.EoaTaskMapper;
import com.flysky.study.mybatis.mapper.SysUserMapper;
import com.flysky.study.mybatis.model.EoaTask;
import com.flysky.study.mybatis.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@RestController
public class TestController {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private EoaTaskMapper eoaTaskMapper;

    @Transactional
    @GetMapping("test")
    public Object test() {
        System.out.println("fsjdfa;f");
        SysUser/**/ sysUser = sysUserMapper.selectById(1L);
//        System.out.println(sysUser.getId() + " 333 " + sysUser.getName());
        return sysUser;
    }
    @GetMapping("t")
    public Object t() {
        System.out.println("fsjdfa;f");
        EoaTask model = new EoaTask().setTaskName("fdsa").setCreatedBy("'fdas")
                .setStatus(3)
                ;

        int result  = eoaTaskMapper.insert(model);
//        System.out.println(sysUser.getId() + " 333 " + sysUser.getName());
        return result;
    }

    public static void main(String[] args) {
        T t= new T();
        String validate = MyValidatorUtil.validate(t);
        System.out.println(validate);


    }

    static class T{
        @NotEmpty
        public String test="";

        public T() {
            set.add("1;");
        }

        @NotEmpty
        public Set<String> set=new HashSet<>();

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }
    }
}
