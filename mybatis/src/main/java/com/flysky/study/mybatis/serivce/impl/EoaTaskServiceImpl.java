package com.flysky.study.mybatis.serivce.impl;

import com.flysky.study.mybatis.dao.EoaTaskDao;
import com.flysky.study.mybatis.model.EoaTask;
import com.flysky.study.mybatis.serivce.EoaTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EoaTaskServiceImpl implements EoaTaskService {
    @Override
    public List<EoaTask> list() {
        return eoaTaskDao.list();
    }

    @Autowired
    private EoaTaskDao eoaTaskDao;


}
