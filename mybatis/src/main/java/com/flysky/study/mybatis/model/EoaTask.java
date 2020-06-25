package com.flysky.study.mybatis.model;

import javax.validation.constraints.Size;
import java.util.Date;

public class EoaTask {
	/**
	 * ,所属表字段为eoa_task.id
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	private Integer id;

	/**
	 * ,所属表字段为eoa_task.task_name
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	@Size(max = 255)
	private String taskName;

	/**
	 * ,所属表字段为eoa_task.task_detail_list
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	@Size(max = 255)
	private String taskDetailList;

	/**
	 * ,所属表字段为eoa_task.status
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	private Integer status;

	/**
	 * ,所属表字段为eoa_task.created_by
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	@Size(max = 255)
	private String createdBy;

	/**
	 * ,所属表字段为eoa_task.created_date
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	private Date createdDate;

	/**
	 * 获取  字段:eoa_task.id
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置  字段:eoa_task.id
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	public EoaTask setId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * 获取  字段:eoa_task.task_name
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * 设置  字段:eoa_task.task_name
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	public EoaTask setTaskName(String taskName) {
		this.taskName = taskName;
		return this;
	}

	/**
	 * 获取  字段:eoa_task.task_detail_list
	 * @flysky_generated  2020-06-20 17:55:59.086
	 */
	public String getTaskDetailList() {
		return taskDetailList;
	}

	/**
	 * 设置  字段:eoa_task.task_detail_list
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	public EoaTask setTaskDetailList(String taskDetailList) {
		this.taskDetailList = taskDetailList;
		return this;
	}

	/**
	 * 获取  字段:eoa_task.status
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置  字段:eoa_task.status
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	public EoaTask setStatus(Integer status) {
		this.status = status;
		return this;
	}

	/**
	 * 获取  字段:eoa_task.created_by
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * 设置  字段:eoa_task.created_by
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	public EoaTask setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	/**
	 * 获取  字段:eoa_task.created_date
	 * @flysky_generated  2020-06-20 17:55:59.087
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * 设置  字段:eoa_task.created_date
	 * @flysky_generated  2020-06-20 17:55:59.088
	 */
	public EoaTask setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
}