package com.flysky.study.dp.creational.abstract_factory;

import static com.flysky.study.dp.creational.abstract_factory.em.Direction.*;

public class MazeGame {
    public Maze createMaze(MazeFactory factory) {
        Maze maze = factory.makeMaze();
        Room room1=factory.makeRoom(1);
        Room room2=factory.makeRoom(2);

        maze.addRoom(room1);
        maze.addRoom(room2);

        Door door = factory.makeDoor(room1, room2);


        room1.setSide(EAST,factory.makeWall());
        room1.setSide(SOUTH,door);
        room1.setSide(WEST,factory.makeWall());
        room1.setSide(NORTH,factory.makeWall());



        room2.setSide(EAST,factory.makeWall());
        room2.setSide(SOUTH,factory.makeWall());
        room2.setSide(WEST,factory.makeWall());
        room2.setSide(NORTH,door);




        return maze;
    }
}
