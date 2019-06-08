package com.flysky.study.dp.creational.prototype;

import com.flysky.study.dp.creational.prototype.bomb.BombedWall;
import com.flysky.study.dp.creational.prototype.bomb.RoomWithABomb;
import org.junit.Test;

public class PrototypeTest {
    @Test
    public void test(){
        MazeGame mg = new MazeGame();
        Maze maze = mg.createMaze(new MazePrototypeFactory(new Maze(),new Room(1),new Wall(),new Door(null,null)));
        System.out.println(maze);
    }
    @Test
    public void testBomb(){
        MazeGame mg = new MazeGame();
        MazePrototypeFactory factory = new MazePrototypeFactory(new Maze(), new RoomWithABomb(10), new BombedWall(), new Door(null, null));
        Maze maze = mg.createMaze(factory);

        System.out.println(maze);
    }
}
