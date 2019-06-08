package com.flysky.study.dp.creational.builder;

import com.flysky.study.dp.creational.abstract_factory.em.Direction;

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

    public boolean isExistRoom(int room) {
        for (Room r : rooms) {
            if (r.getNo() == room) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "------Maze------\nMaze{" +
                "rooms=" + rooms +
                '}';
    }

    private List<Room> rooms = new ArrayList<>();

    public Room getRoom(int room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getNo() == room) {
                return rooms.get(i);
            }
        }
        return null;
    }

    public Direction commonSide(int roomFrom, int roomTo) {

        if (roomFrom > this.rooms.size() || roomTo > this.rooms.size()) {
            throw new RuntimeException("房间越界");
        }

        int result = roomFrom - roomTo;

        if (result == east) {
            return Direction.EAST;
        }

        if (result == west) {
            return Direction.WEST;
        }

        if (result == north) {
            return Direction.NORTH;
        }

        if (result == south) {
            return Direction.SOUTH;
        }

        return null;
    }

    private int MAX_COLUMN = 10;

    private int east = -1;
    private int west = -east;
    private int north = MAX_COLUMN;
    private int south = -north;
}
