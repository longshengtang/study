package com.flysky.study.kata;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private FizzBuzz f;

    @Before
    public void setUp() {
        f = new FizzBuzz();
    }

    @Test
    public void givenIndivisibleNumberThenRawNumber() {
        calculate(1, "1");
        calculate(2, "2");
        calculate(4, "4");
        calculate(7, "7");
    }

    @Test
    public void givenDivisibleNumberThreeThenFizz() {
        calculate(3, "fizz");
        calculate(6, "fizz");
        calculate(9, "fizz");
        calculate(15, "fizz");
        calculate(30, "fizz");
    }

    @Test
    public void givenDivisibleNumberFiveThenBuzz() {
        calculate(5, "buzz");
        calculate(10, "buzz");
        calculate(20, "buzz");
        calculate(25, "buzz");
        calculate(35, "buzz");
    }

    private void calculate(int number, String expected) {
        assertThat(f.find(number)).isEqualTo(expected);
    }
}
