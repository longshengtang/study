package com.flysky.study.mybatis.serivce.impl;

import com.flysky.study.mybatis.common.BaseServiceImpl;
import com.flysky.study.mybatis.mapper.SystemLogMapper;
import com.flysky.study.mybatis.model.SysUser;
import com.flysky.study.mybatis.model.SystemLog;
import com.flysky.study.mybatis.serivce.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService {

    @Transactional
    @Override
    public int saveAndLog(SysUser user) {
        super.insert(user);
        SystemLog log = new SystemLog();
        log.setContent("保存用户" + user.getName());
        log.setMenuId(1);
        log.setOperationId(1);
        logMapper.insert(log);
        if (1 == 1) {
            throw new RuntimeException("模拟事务异常，希望能够回滚已经成功保存的用户");
        }
        return 1;
    }

    @Autowired
    private SystemLogMapper logMapper;


}