package com.flysky.study.dp.behavioral.command.fan;

import com.flysky.study.dp.behavioral.command.Command;

public class AirFanMediumOnCommand extends AbstractAirFanCommand implements Command {
    public AirFanMediumOnCommand(AirFan airFan) {
        super(airFan);
    }

    @Override
    protected void setGear() {
        getAirFan().medium();
    }
}
