package com.flysky.study.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
public class SysUser {
	/**
	 * 主键,所属表字段为flysky..sys_user.id
	 * @flysky_generated  2018-11-07 00:09:09.820
	 */
	@ApiModelProperty("主键")
	private Long id;

	/**
	 * 名称,所属表字段为flysky..sys_user.name
	 * @flysky_generated  2018-11-07 00:09:09.821
	 */
	@ApiModelProperty("名称")
	private String name;

	/**
	 * 获取 主键 字段:flysky..sys_user.id
	 * @flysky_generated  2018-11-07 00:09:09.821
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键 字段:flysky..sys_user.id
	 * @flysky_generated  2018-11-07 00:09:09.821
	 */
	public SysUser setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * 获取 名称 字段:flysky..sys_user.name
	 * @flysky_generated  2018-11-07 00:09:09.821
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 名称 字段:flysky..sys_user.name
	 * @flysky_generated  2018-11-07 00:09:09.821
	 */
	public SysUser setName(String name) {
		this.name = name;
		return this;
	}
}