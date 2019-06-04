package com.flysky.study.dp.command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    private List<Command> commands = new ArrayList<>();
}
