package com.flysky.study.dp.command.light;

import com.flysky.study.dp.command.Command;

public class LightOffCommand implements Command {

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }

    private Light light;
}
