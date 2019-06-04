package com.flysky.study.dp.command.tv;

import com.flysky.study.dp.command.Command;

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
