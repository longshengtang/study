package com.flysky.study.mybatis.common;

import java.util.List;

public interface BaseService<T, PK extends java.io.Serializable> {

    /**
     * 插入model对象到数据库，并返回插入的条数<br>
     * 如果自增主键被返回，会存放在model的对应属性里
     *
     * @param model
     * @return
     */
    int insert(T model);

    /**
     * 删除主键值为id数据库记录，并返回被删除条数
     *
     * @param id
     * @return
     */
    int deleteById(PK id);

    /**
     * 更新全部列值，并返回受影响行数
     *
     * @param model
     */
    int updateById(T model);

    /**
     * 有选择的更新列值，并返回受影响的行数
     *
     * @param model
     */
    int updateByIdSelective(T model);

    /**
     * 通过主键查询记录
     *
     * @param id
     * @return
     */
    T selectById(PK id);

    /**
     * 查询所有符合条件参数conditions限定的数据库记录
     *
     * @param paras
     * @return
     */
    <U> List<T> selectList(U paras);

    /**
     * 通过唯一条件(用户自身保证)查询唯一记录
     *
     * @param paras
     * @return
     */
    <U> T selectOne(U paras);
}

