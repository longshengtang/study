package com.flysky.study.dp.command.fan;

import com.flysky.study.dp.command.Command;

public class AirFanLowOnCommand extends AbstractAirFanCommand implements Command{
    public AirFanLowOnCommand(AirFan airFan) {
        super(airFan);
    }

    @Override
    protected void setGear() {
        getAirFan().low();
    }
}
