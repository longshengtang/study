package com.flysky.study.dp.behavioral.command.fan;

import com.flysky.study.dp.behavioral.command.Command;

public class AirFanOffCommand extends AbstractAirFanCommand implements Command {

    public AirFanOffCommand(AirFan airFan) {
        super(airFan);
    }

    @Override
    protected void setGear() {
        getAirFan().off();
    }
}
