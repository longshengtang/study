package com.flysky.study.kata.bowling;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testZeroScore() {
        rollMany(20, 0);
        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    public void test() {
        game.roll(5);
        game.roll(3);
        rollMany(18, 0);
        assertThat(game.getScore()).isEqualTo(8);
    }

    @Test
    public void testOneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore()).isEqualTo(16);
    }

    @Test
    public void testOneStrike() {
        game.roll(10);//19
        game.roll(6);//25
        game.roll(3);//28
        game.roll(7);//35
        rollMany(16, 0);
        assertThat(game.getScore()).isEqualTo(35);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);

        }
    }
}
