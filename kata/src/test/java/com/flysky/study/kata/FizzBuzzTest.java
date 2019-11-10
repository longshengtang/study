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
    public void givenIndivisibleNumberThenRawNumber() {
        expectedForInput(1, "1");
        expectedForInput(2, "2");
        expectedForInput(4, "4");
        expectedForInput(14, "14");
        expectedForInput(47, "47");
    }

    @Test
    public void givenDivisibleByThreeThenFizz() {
        expectedForInput(3, "fizz");
        expectedForInput(6, "fizz");
        expectedForInput(9, "fizz");
    }


    @Test
    public void givenDivisibleByFiveThenBuzz() {
        String expected = "buzz";
        expectedForInput(5, expected);
        expectedForInput(10, expected);
        expectedForInput(20, expected);
        expectedForInput(35, expected);
    }


    @Test
    public void givenDivisibleByFiveAndThreeThenFizzBuzz() {
        String expected = "fizzBuzz";
        expectedForInput(15, expected);
        expectedForInput(30, expected);
        expectedForInput(45, expected);
        expectedForInput(60, expected);
        expectedForInput(75, expected);
        expectedForInput(90, expected);
        expectedForInput(105, expected);
        expectedForInput(120, expected);
    }

    private void expectedForInput(int input, String expected) {
        assertThat(f.find(input)).isEqualTo(expected);
    }
}
