package com.flysky.study.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
public class SysUser {
	/**
	 * 主键,所属表字段为sys_user.id
	 * @flysky_generated
	 */
	@ApiModelProperty("主键")
	private Long id;

	/**
	 * 名称,所属表字段为sys_user.name
	 * @flysky_generated
	 */
	@ApiModelProperty("名称")
	private String name;

	/**
	 * 获取 主键 字段:sys_user.id
	 * @flysky_generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键 字段:sys_user.id
	 * @flysky_generated
	 */
	public SysUser setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * 获取 名称 字段:sys_user.name
	 * @flysky_generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 名称 字段:sys_user.name
	 * @flysky_generated
	 */
	public SysUser setName(String name) {
		this.name = name;
		return this;
	}
}