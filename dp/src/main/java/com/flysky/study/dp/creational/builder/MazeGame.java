package com.flysky.study.dp.creational.builder;

public class MazeGame {
    public Maze createComplexMaze(MazeBuilder builder) {
        builder.buildMaze();
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildRoom(3);
        builder.buildRoom(4);
        builder.buildRoom(5);
        builder.buildRoom(6);
        builder.buildDoor(1, 2);
        return builder.getMaze();
    }
}
