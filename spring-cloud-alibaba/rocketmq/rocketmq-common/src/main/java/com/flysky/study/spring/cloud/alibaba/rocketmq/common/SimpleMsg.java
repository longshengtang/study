package com.flysky.study.spring.cloud.alibaba.rocketmq.common;

/**
 * @author sorie
 */
public class SimpleMsg {

	private String msg;

	public SimpleMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
