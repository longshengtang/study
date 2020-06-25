package com.flysky.study.mybatis.dao;

import com.flysky.study.mybatis.mapper.EoaTaskMapper;
import com.flysky.study.mybatis.model.EoaTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EoaTaskDao {

    @Autowired
    private EoaTaskMapper eoaTaskMapper;


    public List<EoaTask> list() {
        return eoaTaskMapper.selectList(null);
    }
}
