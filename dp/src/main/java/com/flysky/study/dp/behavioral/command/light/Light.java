package com.flysky.study.dp.behavioral.command.light;

public class Light {

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("打开" + name + "灯");
    }

    public void off() {
        System.out.println("关闭" + name + "灯");
    }

    private String name;
}
