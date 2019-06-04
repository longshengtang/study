package com.flysky.study.dp.command.tv;

public class TV {
    public TV(String name) {
        this.name=name;
    }

    public void on(){
        System.out.println("打开"+name+"电视");
    }

    public void off(){
        System.out.println("关闭"+name+"电视");
    }

    private String name;
}
