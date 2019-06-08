package com.flysky.study.dp.creational.builder;

import static com.flysky.study.dp.creational.abstract_factory.em.Direction.*;

public class StandardMazeBuilder extends MazeBuilder {

    @Override
    public void buildMaze() {
        currentMaze = new Maze();
    }

    @Override
    public void buildRoom(int room) {
        if (!this.currentMaze.isExistRoom(room)) {
            Room newRoom = new Room(room);
            newRoom.setSide(EAST, new Wall());
            newRoom.setSide(SOUTH, new Wall());
            newRoom.setSide(WEST, new Wall());
            newRoom.setSide(NORTH, new Wall());
            this.currentMaze.addRoom(newRoom);
            return;
        }
        System.err.println("房间号" + room + "已经存在！");
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo) {
        Room f = this.currentMaze.getRoom(roomFrom);
        Room t = this.currentMaze.getRoom(roomTo);
        Door door = new Door(f, t);
        f.setSide(this.currentMaze.commonSide(roomFrom, roomTo), door);
        t.setSide(this.currentMaze.commonSide(roomTo, roomFrom), door);
    }

    @Override
    public Maze getMaze() {
        return this.currentMaze;
    }

    private Maze currentMaze;
}
