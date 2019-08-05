package com.flysky.study.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@ApiModel("用户")
public class SysUser implements Serializable {

    /**
     * 测试整型,所属表字段为sys_user.test_id
     *
     * @flysky_generated 2019-08-01 23:18:42.615
     */
    @ApiModelProperty(value = "测试整型")
    private Integer testId;
    /**
     * 更新日期,所属表字段为sys_user.update_time
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
    /**
     * 创建日期,所属表字段为sys_user.create_time
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
    /**
     * 密码,所属表字段为sys_user.password
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    @Size(max = 64)
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 用户名称,所属表字段为sys_user.user_name
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    @Size(max = 255)
    @ApiModelProperty(value = "用户名称")
    private String userName;
    /**
     * 名称,所属表字段为sys_user.name
     *
     * @flysky_generated 2019-08-01 23:18:42.613
     */
    @Size(max = 512)
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 主键,所属表字段为sys_user.id
     *
     * @flysky_generated 2019-08-01 23:18:42.612
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    StringBuilder sb = new StringBuilder();

    /**
     * 获取 主键 字段:sys_user.id
     *
     * @flysky_generated 2019-08-01 23:18:42.613
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键 字段:sys_user.id
     *
     * @flysky_generated 2019-08-01 23:18:42.613
     */
    public SysUser setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 名称 字段:sys_user.name
     *
     * @flysky_generated 2019-08-01 23:18:42.613
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 名称 字段:sys_user.name
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public SysUser setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取 用户名称 字段:sys_user.user_name
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名称 字段:sys_user.user_name
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public SysUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * 获取 密码 字段:sys_user.password
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码 字段:sys_user.password
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * 获取 创建日期 字段:sys_user.create_time
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建日期 字段:sys_user.create_time
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public SysUser setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 获取 更新日期 字段:sys_user.update_time
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新日期 字段:sys_user.update_time
     *
     * @flysky_generated 2019-08-01 23:18:42.614
     */
    public SysUser setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    /**
     * 获取 测试整型 字段:sys_user.test_id
     *
     * @flysky_generated 2019-08-01 23:18:42.615
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * 设置 测试整型 字段:sys_user.test_id
     *
     * @flysky_generated 2019-08-01 23:18:42.615
     */
    public SysUser setTestId(Integer testId) {
        this.testId = testId;
        return this;
    }

    /**
     * ,sys_user
     *
     * @flysky_generated 2019-08-01 23:18:42.615
     */
    @Override
    public String toString() {
        return "SysUser{" + "id=" + id + ",name+='" + name + "'"
                + ",userName+='" + userName + "'" + ",password+='" + password
                + "'" + ",createTime=" + createTime + ",updateTime="
                + updateTime + ",testId=" + testId + "}";
    }

}