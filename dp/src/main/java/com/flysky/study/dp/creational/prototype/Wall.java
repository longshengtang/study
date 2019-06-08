package com.flysky.study.dp.creational.prototype;

public class Wall implements MapSite {
    @Override
    public boolean enter() {
        return false;
    }

    @Override
    public String toString() {
        return "Wall{}";
    }

    @Override
    protected Wall clone() {
        try {
            return (Wall) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
