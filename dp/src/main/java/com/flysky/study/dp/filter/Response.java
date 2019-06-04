package com.flysky.study.dp.filter;

public class Response {
    private String code;

    private String data;

    public String getCode() {
        return code;
    }

    public Response setCode(String code) {
        this.code = code;
        return this;
    }

    public String getData() {
        return data;
    }

    public Response setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
