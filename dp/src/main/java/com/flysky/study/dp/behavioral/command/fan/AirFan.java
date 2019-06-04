package com.flysky.study.dp.behavioral.command.fan;

public class AirFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    private int speed = OFF;

    private final String location;

    public AirFan(String location) {
        this.location = location;
    }

    public void high() {
        speed = HIGH;
        System.out.println(location + "风扇高速运转");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + "风扇中速运转");
    }

    public void low() {
        speed = LOW;
        System.out.println(location + "风扇低速运转");
    }

    public void off() {
        speed = OFF;
        System.out.println(location + "风扇关闭了");
    }

    public int getSpeed() {
        return speed;
    }
}
