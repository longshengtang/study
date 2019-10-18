package com.flysky.study.kata;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private FizzBuzz f;

    @Before
    public void setUp() throws Exception {
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
        calculate(13, "13");
    }

    private void calculate(int number, String expected) {
        assertThat(f.find(number)).isEqualTo(expected);
    }

    @Test
    public void givenDivisibleThreeThenFizz() {
        calculate(3, "fizz");
        calculate(6, "fizz");
        calculate(9, "fizz");
        calculate(12, "fizz");
        calculate(15, "fizz");
        calculate(30, "fizz");
    }
    @Test
    public void givenDivisibleFiveThenBuzz() {
        calculate(5, "buzz");
        calculate(10, "buzz");
        calculate(20, "buzz");
        calculate(25, "buzz");
        calculate(35, "buzz");
    }
}
