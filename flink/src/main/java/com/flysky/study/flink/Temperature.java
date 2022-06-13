package com.flysky.study.flink;

public class Temperature {
    private double value;
    private long time;

    public Temperature() {
    }

    public Temperature(double value, long time) {
        this.value = value;
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "value=" + value +
                ", time=" + time +
                '}';
    }
}
