package com.flysky.study.mybatis.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


@ApiModel("基础实体")
public class BaseEntity implements Serializable {

    /**
     * 当前页(第几页)
     */
    @ApiModelProperty(value = "当前页(第几页)", dataType = "int")
    private Integer pageNum;    //页码

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量", dataType = "int")
    private Integer pageSize;


    /**
     * 排序(不含order by)
     */
    @ApiModelProperty(value = "排序(不含order by)", dataType = "String")
    private String orderBy;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", dataType = "date")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", dataType = "date")
    private Date endTime;

    public Integer getPageNum() {
        return pageNum;
    }

    public BaseEntity setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public BaseEntity setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public BaseEntity setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public BaseEntity setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public BaseEntity setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderBy='" + orderBy + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
