package com.flysky.study.dp.creational.abstract_factory;

import com.flysky.study.dp.creational.abstract_factory.bomb.BombMazeFactory;
import com.flysky.study.dp.creational.abstract_factory.enchant.EnchantedMazeFactory;
import org.junit.Test;

public class MazeGameTest {

    @Test
    public void testMazeGame() {
        createMaze(new MazeFactory());
    }

    @Test
    public void testBombMazeGame() {
        createMaze(new BombMazeFactory());
    }

    @Test
    public void testEnchantedMazeGame() {
        createMaze(new EnchantedMazeFactory());
    }

    private void createMaze(MazeFactory factory) {
        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze(factory);
        maze.enter();

        System.out.println(maze);
    }
}
