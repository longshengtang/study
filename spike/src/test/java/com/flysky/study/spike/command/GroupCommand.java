package com.flysky.study.spike.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupCommand extends Command {

    public GroupCommand(Command... commands) {
        this.commands = Arrays.asList(commands);
    }

    public boolean invoke() throws RuntimeException {

        for (Command command : commands) {
            boolean result = command.invoke();
            if (result) {
                return true;
            }
        }
        return false;

    }

    private List<Command> commands;

    public void addCommand(Command command) {
        commands.add(command);
    }

    private List<GroupCommand> groupCommands = new ArrayList<>();

    public void addGroup(GroupCommand group) {
        groupCommands.add(group);
    }
}
