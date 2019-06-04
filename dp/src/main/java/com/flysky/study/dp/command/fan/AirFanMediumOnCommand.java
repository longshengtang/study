package com.flysky.study.dp.command.fan;

import com.flysky.study.dp.command.Command;

public class AirFanMediumOnCommand extends AbstractAirFanCommand implements Command {
    public AirFanMediumOnCommand(AirFan airFan) {
        super(airFan);
    }

    @Override
    protected void setGear() {
        getAirFan().medium();
    }
}
