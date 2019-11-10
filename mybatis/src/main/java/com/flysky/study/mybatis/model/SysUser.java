package com.flysky.study.mybatis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@ApiModel("用户")
public class SysUser implements Serializable {

    /**
	 * 测试整型
	 * @flysky_generated  2019-08-11 16:46:40.074
	 */
	@ApiModelProperty(value = "测试整型")
	private Integer testId;
	/**
	 * 更新日期
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	@ApiModelProperty(value = "更新日期")
	private Date updateTime;
	/**
	 * 创建日期
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	@ApiModelProperty(value = "创建日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 密码
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	@Size(max = 64)
	@ApiModelProperty(value = "密码")
	private String password;
	/**
	 * 用户名称
	 * @flysky_generated  2019-08-11 16:46:40.072
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "用户名称")
	private String userName;
	/**
	 * 名称
	 * @flysky_generated  2019-08-11 16:46:40.072
	 */
	@Size(max = 512)
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	 * 主键
	 * @flysky_generated  2019-08-11 16:46:40.071
	 */
	@ApiModelProperty(value = "主键")
	private Long id;
	StringBuilder sb = new StringBuilder();

    /**
	 * 获取 主键
	 * @flysky_generated  2019-08-11 16:46:40.072
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键
	 * @flysky_generated  2019-08-11 16:46:40.072
	 */
	public SysUser setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * 获取 名称
	 * @flysky_generated  2019-08-11 16:46:40.072
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 名称
	 * @flysky_generated  2019-08-11 16:46:40.072
	 */
	public SysUser setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获取 用户名称
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置 用户名称
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public SysUser setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * 获取 密码
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置 密码
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public SysUser setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * 获取 创建日期
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建日期
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public SysUser setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * 获取 更新日期
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置 更新日期
	 * @flysky_generated  2019-08-11 16:46:40.073
	 */
	public SysUser setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	/**
	 * 获取 测试整型
	 * @flysky_generated  2019-08-11 16:46:40.074
	 */
	public Integer getTestId() {
		return testId;
}

    /**
     * 设置 测试整型
     * @flysky_generated  2019-08-11 16:46:40.074
     */
    public SysUser setTestId(Integer testId) {
        this.testId = testId;
        return this;
    }
}