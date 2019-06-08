package com.flysky.study.dp.creational.abstract_factory;

public class Wall implements MapSite {
    @Override
    public boolean enter() {
        return false;
    }

    @Override
    public String toString() {
        return "Wall{}";
    }
}
