package com.flysky.study.dp.creational.abstract_factory.bomb;

import com.flysky.study.dp.creational.abstract_factory.MazeFactory;
import com.flysky.study.dp.creational.abstract_factory.Room;
import com.flysky.study.dp.creational.abstract_factory.Wall;

public class BombMazeFactory extends MazeFactory {
    @Override
    public Room makeRoom(int no) {
        return new RoomWithABomb(no);
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }
}
