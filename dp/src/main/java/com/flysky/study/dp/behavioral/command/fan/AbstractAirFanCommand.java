package com.flysky.study.dp.behavioral.command.fan;

import com.flysky.study.dp.behavioral.command.Command;

public abstract class AbstractAirFanCommand implements Command {

    public AbstractAirFanCommand(AirFan airFan) {
        this.airFan = airFan;
    }

    @Override
    public void execute() {
        savePreSpeed();
        setGear();
    }

    private void savePreSpeed() {
        this.preSpeed = this.airFan.getSpeed();
    }

    /**
     * 设置风扇档位
     */
    protected abstract void setGear();

    @Override
    public void undo() {
        switch (preSpeed) {
            case AirFan.HIGH:
                this.airFan.high();
                break;
            case AirFan.MEDIUM:
                this.airFan.medium();
                break;
            case AirFan.LOW:
                this.airFan.low();
                break;
            case AirFan.OFF:
                this.airFan.off();
                break;
        }
    }

    public AirFan getAirFan() {
        return airFan;
    }

    private AirFan airFan;
    private int preSpeed;
}
