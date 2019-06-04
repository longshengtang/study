package com.flysky.study.dp.command.tv;

import com.flysky.study.dp.command.Command;

public class TVOffCommand implements Command {

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }


    @Override
    public void execute() {
        this.tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }

    private final TV tv;
}
