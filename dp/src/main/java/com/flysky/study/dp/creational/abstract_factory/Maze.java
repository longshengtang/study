package com.flysky.study.dp.creational.abstract_factory;

import java.util.ArrayList;
import java.util.List;

public class Maze implements MapSite {
    @Override
    public boolean enter() {
        return false;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "------Maze------\nMaze{" +
                "rooms=" + rooms +
                '}';
    }

    private List<Room> rooms=new ArrayList<>();
}
