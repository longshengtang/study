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
        inputAndExpected(1, "1");
        inputAndExpected(2, "2");
        inputAndExpected(4, "4");
        inputAndExpected(14, "14");
        inputAndExpected(47, "47");
    }

    @Test
    public void givenDivisibleByThreeNumberThenFizz() {
        String expected = "fizz";
        inputAndExpected(3, expected);
        inputAndExpected(6, expected);
        inputAndExpected(9, expected);
        inputAndExpected(15, expected);
        inputAndExpected(30, expected);
    }

    private void inputAndExpected(int input, String expected) {
        assertThat(f.find(input)).isEqualTo(expected);
    }
}
