package com.flysky.study.kata;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private FizzBuzz f;

    @Before
    public void setUp(){
        f = new FizzBuzz();
    }

    @Test
    public void givenIndivisibleThenRawNumber() {
        calculate(1, "1");
        calculate(2, "2");
        calculate(4, "4");
        calculate(7, "7");
        calculate(8, "8");
        calculate(11, "11");
    }
    @Test
    public void givenContainCharOf3ThenFizz() {
        String expected = "fizz";
        calculate(13, expected);
        calculate(23, expected);
        calculate(43, expected);
        calculate(31, expected);
        calculate(32, expected);
        calculate(34, expected);
    }

    private void calculate(int number, String expected) {
        assertThat(f.find(number)).isEqualTo(expected);
    }

    @Test
    public void givenDivisibleThreeThenFizz() {
        String expected = "fizz";
        calculate(3, expected);
        calculate(6, expected);
        calculate(9, expected);
        calculate(12, expected);
        calculate(15, expected);
        calculate(30, expected);
        calculate(51, expected);
        calculate(53, expected);
    }
    @Test
    public void givenDivisibleFiveThenBuzz() {
        calculate(5, "buzz");
        calculate(10, "buzz");
        calculate(20, "buzz");
        calculate(25, "buzz");
    }
    @Test
    public void givenContainCharOf5ThenBuzz() {
        String expected = "buzz";
        calculate(52, expected);
        calculate(56, expected);
        calculate(58, expected);
        calculate(59, expected);
    }
}
