package com.flysky.study.dp.creational.builder;

public abstract class MazeBuilder {
    public abstract void buildMaze();

    public abstract void buildRoom(int room);

    public abstract void buildDoor(int roomFrom, int roomTo);

    public abstract Maze getMaze();
}
