package com.flysky.study.springweb.service;

public abstract class User {
    private String name = "haha";
    private String addr = "home";

    public abstract void add();
    public abstract void delete();
    public abstract void update();
    public abstract void find();
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
