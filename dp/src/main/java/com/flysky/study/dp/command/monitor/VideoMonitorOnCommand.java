package com.flysky.study.dp.command.monitor;

import com.flysky.study.dp.command.Command;

public class VideoMonitorOnCommand implements Command {

    public VideoMonitorOnCommand(VideoMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void execute() {
        this.monitor.on();
    }

    @Override
    public void undo() {
        this.monitor.off();
    }

    private VideoMonitor monitor;
}
