package com.flysky.study.dp.command.fan;

import com.flysky.study.dp.command.Command;

public class AirFanHighOnCommand extends AbstractAirFanCommand implements Command {
    public AirFanHighOnCommand(AirFan airFan) {
        super(airFan);
    }

    @Override
    protected void setGear() {
        getAirFan().high();
    }
}
