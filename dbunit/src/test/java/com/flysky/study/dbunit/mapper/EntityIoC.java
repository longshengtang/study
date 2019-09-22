package com.flysky.study.dbunit.mapper;

import com.flysky.study.dbunit.MyValue;
import com.flysky.study.mybatis.mapper.SysUserMapper;
import com.flysky.study.mybatis.model.SysUser;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

//@Configurable(autowire = Autowire.BY_TYPE)
@Configurable(preConstruction=true,dependencyCheck=true,autowire=Autowire.BY_TYPE)

public class EntityIoC {

    @Value("${mytest.abc}")
    private String test;

    @MyValue("${mytest.abc}")
    private String test2;

    @Autowired
    private SysUserMapper mapper;

    public SysUser get() {
        System.out.println(test + "," + test2);
        return mapper.selectById(1L);
    }
}
