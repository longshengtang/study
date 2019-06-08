package com.flysky.study.dp.creational.builder;

import org.junit.Test;

public class MazeBuilderTest {

    @Test
    public void test() {
        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createComplexMaze(new StandardMazeBuilder());
        System.out.println(maze);
    }
}
