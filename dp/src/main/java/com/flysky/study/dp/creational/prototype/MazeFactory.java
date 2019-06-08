package com.flysky.study.dp.creational.prototype;

public class MazeFactory {
    public Maze makeMaze() {
        return new Maze();
    }

    public Room makeRoom(int no) {
        return new Room(no);

    }

    public Wall makeWall() {
        return new Wall();
    }

    public Door makeDoor(Room room1, Room room2) {
        return new Door(room1, room2);

    }
}
