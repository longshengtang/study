package com.flysky.study.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel("角色")
public class SysRole implements Serializable {
	/**
	 * 主键,所属表字段为sys_role.id
	 * @flysky_generated
	 */
	@ApiModelProperty(value="主键")
	private Long id;

	/**
	 * 名称,所属表字段为sys_role.name
	 * @flysky_generated
	 */
	@Size(max=255)
	@NotBlank
	@ApiModelProperty(value="名称",required=true)
	private String name;

	/**
	 * 获取 主键 字段:sys_role.id
	 * @flysky_generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键 字段:sys_role.id
	 * @flysky_generated
	 */
	public SysRole setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * 获取 名称 字段:sys_role.name
	 * @flysky_generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 名称 字段:sys_role.name
	 * @flysky_generated
	 */
	public SysRole setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * ,sys_role
	 * @flysky_generated
	 */
	@Override
	public String toString() {
		return "SysRole{"+
		"id="+id+
		",name+='"+name+"'"+
		"}";
	}
}