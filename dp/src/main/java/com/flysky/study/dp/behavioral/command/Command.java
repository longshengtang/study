package com.flysky.study.dp.behavioral.command;

public interface Command {
    void execute();
    void undo();
}