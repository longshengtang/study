package com.flysky.study.dp.command.monitor;

public class VideoMonitor {

    public VideoMonitor(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + "视频监控器打开了");
    }

    public void off() {
        System.out.println(location + "视频监控器关闭了");
    }

    private String location;
}
