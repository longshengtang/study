package com.flysky.study.dp.command.monitor;

import com.flysky.study.dp.command.Command;

public class VideoMonitorOffCommand implements Command {

    public VideoMonitorOffCommand(VideoMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void execute() {
        this.monitor.off();
    }

    @Override
    public void undo() {
        this.monitor.on();
    }

    private VideoMonitor monitor;
}
