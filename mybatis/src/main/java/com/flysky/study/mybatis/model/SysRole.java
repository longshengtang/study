package com.flysky.study.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel("角色")
public class SysRole implements Serializable {
	/**
	 * 主键
	 * @flysky_generated
	 */
	@ApiModelProperty(value = "主键")
	private Long id;

	/**
	 * 名称
	 * @flysky_generated
	 */
	@Size(max = 255)
	@NotBlank
	@ApiModelProperty(value = "名称", required = true)
	private String name;

	/**
	 * 获取 主键
	 * @flysky_generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键
	 * @flysky_generated
	 */
	public SysRole setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * 获取 名称
	 * @flysky_generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 名称
	 * @flysky_generated
	 */
	public SysRole setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @flysky_generated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append("]");
		return sb.toString();
	}
}