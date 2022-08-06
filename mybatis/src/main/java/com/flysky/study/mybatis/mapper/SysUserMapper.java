package com.flysky.study.mybatis.mapper;

import com.flysky.study.mybatis.common.BaseMapper;
import com.flysky.study.mybatis.model.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser, Long> {
    @Select("select * from sys_user")
    List<SysUser> test();
//    @Select("select * from sys_user")
//    List<SysUser> selectById3();
//    @Select("select * from sys_user")
//    List<SysUser> selectById3(int a);
}
