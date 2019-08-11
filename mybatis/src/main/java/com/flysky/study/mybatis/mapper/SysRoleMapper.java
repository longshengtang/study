package com.flysky.study.mybatis.mapper;

import com.flysky.study.mybatis.model.SysRole;
import java.util.List;

public interface SysRoleMapper {
	/**
	 * 新写入数据库记录,sys_role
	 * @param sysRole
	 * @flysky_generated_insertSelective
	 */
	int insert(SysRole sysRole);

	/**
	 * ,sys_role
	 * @param id
	 * @flysky_generated_deleteById
	 */
	int deleteById(Long id);

	/**
	 * ,sys_role
	 * @param sysRole
	 * @flysky_generated_updateById
	 */
	int updateById(SysRole sysRole);

	/**
	 * ,sys_role
	 * @param sysRole
	 * @flysky_generated_updateByIdSelective
	 */
	int updateByIdSelective(SysRole sysRole);

	/**
	 * ,sys_role
	 * @param id
	 * @flysky_generated_selectById
	 */
	SysRole selectById(Long id);

	/**
	 * ,sys_role
	 * @param sysRole
	 * @flysky_generated_selectList
	 */
	List<SysRole> selectList(SysRole sysRole);

	/**
	 * ,sys_role
	 * @param sysRole
	 * @flysky_generated_selectOne
	 */
	SysRole selectOne(SysRole sysRole);
}