package com.flysky.study.dp.behavioral.filter;

public class Request {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public Request setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "Request{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
