package com.flysky.study.dp.behavioral.command.fan;

import com.flysky.study.dp.behavioral.command.Command;

public class AirFanLowOnCommand extends AbstractAirFanCommand implements Command {
    public AirFanLowOnCommand(AirFan airFan) {
        super(airFan);
    }

    @Override
    protected void setGear() {
        getAirFan().low();
    }
}
