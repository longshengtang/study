package com.flysky.study.mybatis.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 默认Service实现
 *
 * @author longshengtang
 * @param <T>
 * @param <PK>
 */
public class BaseServiceImpl<T,PK extends java.io.Serializable> implements BaseService<T,PK> {

    @Autowired
    private BaseMapper<T,PK> baseMapper;

    @Override
    public int insert(T model) {
        return this.baseMapper.insert(model);
    }

    @Override
    public int deleteById(PK id) {
        return this.baseMapper.deleteById(id);
    }

    @Override
    public int updateById(T model) {
        return this.baseMapper.updateById(model);
    }

    @Override
    public int updateByIdSelective(T model) {
        return this.baseMapper.updateByIdSelective(model);
    }

    @Override
    public T selectById(PK id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public <U> List<T> selectList(U paras) {
        return this.baseMapper.selectList(paras);
    }

    @Override
    public <U> T selectOne(U paras) {
        return this.baseMapper.selectOne(paras);
    }
}
