package com.flysky.study.dp.creational.abstract_factory.em;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Direction {
    EAST(0), SOUTH(1), WEST(2), NORTH(3);

    Direction(int index) {
        this.index = index;
    }

    public static Direction ofByIndex(final int index) {
        return Arrays.asList(Direction.values()).stream().filter(d -> d.index == index).collect(Collectors.toList()).get(0);
    }

    public int getIndex() {
        return index;
    }

    private int index;

    public static void main(String[] args) {
        System.out.println(Direction.valueOf(1 + ""));
    }
}
