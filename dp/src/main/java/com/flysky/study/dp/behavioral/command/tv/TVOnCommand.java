package com.flysky.study.dp.behavioral.command.tv;

import com.flysky.study.dp.behavioral.command.Command;

public class TVOnCommand implements Command {
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.on();
    }

    @Override
    public void undo() {
        this.tv.off();
    }

    private TV tv;
}
