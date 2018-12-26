package com.flysky.study.mybatis.common;

import java.util.List;

/**
 * 数据库操作基本接口
 *
 * @param <T>  实体类型
 * @param <PK> 主键类型
 * @author longshengtang
 * @since 2017-07-28 10:11:33
 */
public interface BaseMapper<T, PK extends java.io.Serializable> {
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
     * @return 受影响行数
     */
    int deleteById(PK id);

    /**
     * 更新全部列值，并返回受影响行数
     *
     * @param model 被更新对象
     * @return 爱影响的行数
     */
    int updateById(T model);

    /**
     * 更新参数值非空的列，并返回受影响的行数
     *
     * @param model 实体
     * @return 受影响的行数
     */
    int updateByIdSelective(T model);

    /**
     * 通过主键查询记录
     *
     * @param id
     * @return 一条记录或者null
     */
    T selectById(PK id);

    /**
     * 通过唯一条件查询唯一记录(用户自身保证)
     *
     * @param paras 参数
     * @return 返回满足条件的一条记录或者null
     */
    <U> T selectOne(U paras);

    /**
     * 查询符合条件conditions的记录列表<br>
     * （感觉比selectAll更贴切，因为大多数都是查询分页而不是全部，并且从主义上与selectOne更加能够对应得上）
     *
     * @param paras 查询条件
     * @return 记录列表
     */
    <U> List<T> selectList(U paras);
}