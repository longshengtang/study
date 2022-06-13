package com.flysky.study.spike.jdk.stream;

public class JavapRef {
    private int x;
    private int y;

    public JavapRef(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "JavapRef{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
