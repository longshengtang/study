package com.flysky.study.dbunit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Size;

@ApiModel("")
public class SystemLog implements Serializable {
	/**
	 * 主键,所属表字段为system_log.id
	 * @flysky_generated
	 */
	@ApiModelProperty(value = "主键")
	private Long id;

	/**
	 * 菜单id,所属表字段为system_log.menu_id
	 * @flysky_generated
	 */
	@ApiModelProperty(value = "菜单id")
	private Integer menuId;

	/**
	 * 操作id,所属表字段为system_log.operation_id
	 * @flysky_generated
	 */
	@ApiModelProperty(value = "操作id")
	private Integer operationId;

	/**
	 * 操作内容,所属表字段为system_log.content
	 * @flysky_generated
	 */
	@Size(max = 65535)
	@ApiModelProperty(value = "操作内容")
	private String content;

	/**
	 * 获取 主键 字段:system_log.id
	 * @flysky_generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键 字段:system_log.id
	 * @flysky_generated
	 */
	public SystemLog setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * 获取 菜单id 字段:system_log.menu_id
	 * @flysky_generated
	 */
	public Integer getMenuId() {
		return menuId;
	}

	/**
	 * 设置 菜单id 字段:system_log.menu_id
	 * @flysky_generated
	 */
	public SystemLog setMenuId(Integer menuId) {
		this.menuId = menuId;
		return this;
	}

	/**
	 * 获取 操作id 字段:system_log.operation_id
	 * @flysky_generated
	 */
	public Integer getOperationId() {
		return operationId;
	}

	/**
	 * 设置 操作id 字段:system_log.operation_id
	 * @flysky_generated
	 */
	public SystemLog setOperationId(Integer operationId) {
		this.operationId = operationId;
		return this;
	}

	/**
	 * 获取 操作内容 字段:system_log.content
	 * @flysky_generated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置 操作内容 字段:system_log.content
	 * @flysky_generated
	 */
	public SystemLog setContent(String content) {
		this.content = content;
		return this;
	}
}