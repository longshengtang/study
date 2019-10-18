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
        evaluate(1, "1");
        evaluate(2, "2");
    }

    @Test
    public void givenDivisibleThreeThenFizz() {
        evaluate(3, "fizz");
        evaluate(15, "fizz");
        evaluate(30, "fizz");
    }

    @Test
    public void givenDivisibleFiveThenBuzz() {
        evaluate(5,"buzz");
        evaluate(10,"buzz");
    }

    private void evaluate(int number, String expected) {
        assertThat(f.find(number)).isEqualTo(expected);
    }
}
