package com.flysky.study.dp.behavioral.command.fan;

import com.flysky.study.dp.behavioral.command.Command;

public class AirFanHighOnCommand extends AbstractAirFanCommand implements Command {
    public AirFanHighOnCommand(AirFan airFan) {
        super(airFan);
    }

    @Override
    protected void setGear() {
        getAirFan().high();
    }
}
