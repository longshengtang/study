package com.flysky.study.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("用户")
public class SysUser {

	/**
	 * 主键,所属表字段为sys_user.id
	 * @flysky_generated
	 */
	@ApiModelProperty(value = "主键")
	private Long id;
	/**
	 * 名称,所属表字段为sys_user.name
	 * @flysky_generated
	 */
	@Max(value = 512)
	@NotBlank
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	 * 用户名称,所属表字段为sys_user.user_name
	 * @flysky_generated
	 */
	@Max(value = 255)
	@NotBlank
	@ApiModelProperty(value = "用户名称", required = true)
	private String userName;
	/**
	 * 密码,所属表字段为sys_user.password
	 * @flysky_generated
	 */
	@Max(value = 64)
	@NotBlank
	@ApiModelProperty(value = "密码", required = true)
	private String password;
	/**
	 * 创建日期,所属表字段为sys_user.create_time
	 * @flysky_generated
	 */
	@NotNull
	@ApiModelProperty(value = "创建日期")
	private Date createTime;
	/**
	 * 更新日期,所属表字段为sys_user.update_time
	 * @flysky_generated
	 */
	@NotNull
	@ApiModelProperty(value = "更新日期")
	private Date updateTime;
	/**
	 * 测试整型,所属表字段为sys_user.test_id
	 * @flysky_generated
	 */
	@NotNull
	@ApiModelProperty(value = "测试整型", required = true)
	private Integer testId;
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

	/**
	 * 获取 用户名称 字段:sys_user.user_name
	 * @flysky_generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置 用户名称 字段:sys_user.user_name
	 * @flysky_generated
	 */
	public SysUser setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * 获取 密码 字段:sys_user.password
	 * @flysky_generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置 密码 字段:sys_user.password
	 * @flysky_generated
	 */
	public SysUser setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * 获取 创建日期 字段:sys_user.create_time
	 * @flysky_generated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建日期 字段:sys_user.create_time
	 * @flysky_generated
	 */
	public SysUser setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * 获取 更新日期 字段:sys_user.update_time
	 * @flysky_generated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置 更新日期 字段:sys_user.update_time
	 * @flysky_generated
	 */
	public SysUser setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	/**
	 * 获取 测试整型 字段:sys_user.test_id
	 * @flysky_generated
	 */
	public Integer getTestId() {
		return testId;
	}

	/**
	 * 设置 测试整型 字段:sys_user.test_id
	 * @flysky_generated
	 */
	public SysUser setTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
}