package com.flysky.study.dp.creational.prototype;

public class MazePrototypeFactory extends MazeFactory {

    public MazePrototypeFactory(Maze prototypeMaze, Room prototypeRoom, Wall prototypeWall, Door prototypeDoor) {
        this.prototypeMaze = prototypeMaze;
        this.prototypeRoom = prototypeRoom;
        this.prototypeWall = prototypeWall;
        this.prototypeDoor = prototypeDoor;
    }

    @Override
    public Maze makeMaze() {
        return this.prototypeMaze.clone();
    }

    @Override
    public Room makeRoom(int no) {
        Room room = prototypeRoom.clone();
        room.setNo(no);
        return room;
    }

    @Override
    public Wall makeWall() {
        return this.prototypeWall.clone();
    }

    @Override
    public Door makeDoor(Room room1, Room room2) {
        Door door = this.prototypeDoor.clone();
        door.initialize(room1,room2);
        return door;
    }


    private Maze prototypeMaze;
    private Room prototypeRoom;
    private Wall prototypeWall;
    private Door prototypeDoor;
}
