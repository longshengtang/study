package com.flysky.study.dp.behavioral.command;

import com.flysky.study.dp.behavioral.command.Command;
import com.flysky.study.dp.behavioral.command.MacroCommand;
import com.flysky.study.dp.behavioral.command.RemoteController;
import com.flysky.study.dp.behavioral.command.fan.*;
import com.flysky.study.dp.behavioral.command.light.Light;
import com.flysky.study.dp.behavioral.command.light.LightOffCommand;
import com.flysky.study.dp.behavioral.command.light.LightOnCommand;
import com.flysky.study.dp.behavioral.command.monitor.VideoMonitor;
import com.flysky.study.dp.behavioral.command.monitor.VideoMonitorOffCommand;
import com.flysky.study.dp.behavioral.command.monitor.VideoMonitorOnCommand;
import com.flysky.study.dp.behavioral.command.tv.TV;
import com.flysky.study.dp.behavioral.command.tv.TVOffCommand;
import com.flysky.study.dp.behavioral.command.tv.TVOnCommand;
import org.junit.Test;

public class CommandTest {

    @Test
    public void test() {
        RemoteController rc = new RemoteController();

        Light light = new Light("客厅");
        Command onLightCommand = new LightOnCommand(light);
        Command offLightCommand = new LightOffCommand(light);
        rc.setCommand(0, onLightCommand, offLightCommand);

        TV tv = new TV("客厅");
        Command onTVCommand = new TVOnCommand(tv);
        Command offTVCommand = new TVOffCommand(tv);
        rc.setCommand(1, onTVCommand, offTVCommand);

        VideoMonitor monitor = new VideoMonitor("客厅");
        Command videoMonitorOnCommand = new VideoMonitorOnCommand(monitor);
        Command videoMonitorOffCommand = new VideoMonitorOffCommand(monitor);
        rc.setCommand(2, videoMonitorOnCommand, videoMonitorOffCommand);

        MacroCommand onMacroCommand=new MacroCommand();
        onMacroCommand.addCommand(onLightCommand);
        onMacroCommand.addCommand(onTVCommand);
        onMacroCommand.addCommand(videoMonitorOnCommand);

        MacroCommand offMacroCommand=new MacroCommand();
        offMacroCommand.addCommand(offLightCommand);
        offMacroCommand.addCommand(offTVCommand);
        offMacroCommand.addCommand(videoMonitorOffCommand);

        AirFan airFan=new AirFan("客厅");
        Command airHighOnCommand = new AirFanHighOnCommand(airFan);
        Command airMediumOnCommand = new AirFanMediumOnCommand(airFan);
        Command airLowOnCommand = new AirFanLowOnCommand(airFan);
        Command airFanOffCommand = new AirFanOffCommand(airFan);
        rc.setCommand(3,airHighOnCommand,airFanOffCommand);
        rc.setCommand(4,airMediumOnCommand,airFanOffCommand);
        rc.setCommand(5,airLowOnCommand,airFanOffCommand);


        rc.onButtonWasPushed(0);
        rc.offButtonWasPushed(0);
        rc.onButtonWasPushed(1);
        rc.offButtonWasPushed(1);
        rc.onButtonWasPushed(2);
        rc.offButtonWasPushed(2);
        rc.onButtonWasPushed(3);
        rc.offButtonWasPushed(3);
        rc.onButtonWasPushed(4);
        rc.offButtonWasPushed(4);
        rc.onButtonWasPushed(5);
        rc.offButtonWasPushed(5);

        System.out.println(rc);
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        rc.undoButtonWasPushed();
        System.out.println(rc);

    }
}
