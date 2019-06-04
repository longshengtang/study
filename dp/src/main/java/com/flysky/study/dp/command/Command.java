package com.flysky.study.dp.command;

public interface Command {
    void execute();
    void undo();
}