package com.flysky.study.dp.behavioral.command.light;

import com.flysky.study.dp.behavioral.command.Command;

public class LightOnCommand implements Command {

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

    private Light light;
}
