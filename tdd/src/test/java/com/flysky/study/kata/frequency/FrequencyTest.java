package com.flysky.study.kata.frequency;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class FrequencyTest {

    private Frequency f;

    @Before
    public void setUp() {
        f = new Frequency();
    }

    @Test
    public void testReturnEmpty() {
        assertThat(f.count("")).isEqualTo("");
    }

    @Test
    public void testReturnHe() {
        assertThat(f.count("he he")).isEqualTo("he 2\n");
    }

    @Test
    public void testReturnManyWordInOrder() {
        String expected = "a 3\nand 3\nboy 1\nhe 3\nhis 1\nis 5\nll 1\nman 1\nname 1\nstudent 1\nsuper 1\n";
        String actual = f.count("he is a boy and he is is a super man and his name is ll and he is a student");
        assertThat(actual).isEqualTo(expected);
    }
}
