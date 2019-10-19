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
}
