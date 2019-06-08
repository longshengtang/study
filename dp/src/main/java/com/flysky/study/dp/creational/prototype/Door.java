package com.flysky.study.dp.creational.prototype;

public class Door implements MapSite {


    @Override
    public boolean enter() {
        return false;
    }

    public Door() {
    }

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room2 = room2;
    }

    @Override
    public Door clone() {
        try {
            return (Door) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Door{" +
                "room1=" + room1.getNo() +
                ", room2=" + room2.getNo() +
                '}';
    }


    private Room room1;
    private Room room2;

    public void initialize(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }
}
