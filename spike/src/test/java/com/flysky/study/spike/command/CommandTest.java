package com.flysky.study.spike.command;

import org.junit.Before;
import org.junit.Test;

public class CommandTest {


    Command initCommand = new Command();
    Command gcCommand = new Command();
    Command removeCommand = new Command();

    GroupCommand groupCommand = new GroupCommand(initCommand);
    GroupCommand gcBeforeInit = new GroupCommand(gcCommand,initCommand);
    GroupCommand removeBeforeInit = new GroupCommand(removeCommand,initCommand);

    @Before
    public void setUp() {
//
//        groupCommand = new GroupCommand();
//
//        groupCommand.addCommand(first);
//        Command second = new Command();
//        groupCommand.addCommand(second);
//        Command three = new Command();
//        groupCommand.addCommand(three);
//        groupCommand.invoke();
    }

    @Test
    public void testThreeCommandInvoke() {
//        groupCommand.addCommand(gcCommand);
//        groupCommand.addCommand(removeCommand);

        groupCommand.addGroup(gcBeforeInit);
        groupCommand.addGroup(removeBeforeInit);
        groupCommand.invoke();

    }
}
