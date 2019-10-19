package com.flysky.study.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    @Test
    public void givenIndivisibleNumberThenRawNumber() {
        FizzBuzz f = new FizzBuzz();
        assertThat(f.find(1)).isEqualTo("1");
        assertThat(f.find(2)).isEqualTo("2");
        assertThat(f.find(4)).isEqualTo("4");
        assertThat(f.find(14)).isEqualTo("14");
        assertThat(f.find(47)).isEqualTo("47");
    }
    @Test
    public void givenDivisibleByThreeNumberThenFizz() {
        FizzBuzz f = new FizzBuzz();
        assertThat(f.find(3)).isEqualTo("fizz");
        assertThat(f.find(6)).isEqualTo("fizz");
        assertThat(f.find(9)).isEqualTo("fizz");
        assertThat(f.find(15)).isEqualTo("fizz");
        assertThat(f.find(30)).isEqualTo("fizz");
    }
}
