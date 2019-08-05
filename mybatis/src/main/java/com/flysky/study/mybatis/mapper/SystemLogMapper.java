package com.flysky.study.mybatis.mapper;

import com.flysky.study.mybatis.model.SystemLog;
import java.util.List;

public interface SystemLogMapper {
	/**
	 * 新写入数据库记录,system_log
	 * @param systemLog
	 * @flysky_generated_insertSelective
	 */
	int insert(SystemLog systemLog);

	/**
	 * ,system_log
	 * @param id
	 * @flysky_generated_deleteById
	 */
	int deleteById(Long id);

	/**
	 * ,system_log
	 * @param systemLog
	 * @flysky_generated_updateById
	 */
	int updateById(SystemLog systemLog);

	/**
	 * ,system_log
	 * @param systemLog
	 * @flysky_generated_updateByIdSelective
	 */
	int updateByIdSelective(SystemLog systemLog);

	/**
	 * ,system_log
	 * @param id
	 * @flysky_generated_selectById
	 */
	SystemLog selectById(Long id);

	/**
	 * ,system_log
	 * @param systemLog
	 * @flysky_generated_selectList
	 */
	List<SystemLog> selectList(SystemLog systemLog);

	/**
	 * ,system_log
	 * @param systemLog
	 * @flysky_generated_selectOne
	 */
	SystemLog selectOne(SystemLog systemLog);
}