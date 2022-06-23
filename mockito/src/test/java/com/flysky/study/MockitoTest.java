package com.flysky.study;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Spy
    private SpyTest test;

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void out_contains() {
        String c = "hello6";
        System.out.println(c);
        Assertions.assertThat(outContent.toString()).isEqualTo(c + System.lineSeparator());
    }


    @Test
    public void out_content_contains() {
        System.out.println(81 / 2);
        Assertions.assertThat(outContent.toString()).contains("40");
    }

    @Test
    public void should_invoke_real_method() {
//        doReturn("hello mockito").when(test).hello();
        when(test.hello()).thenReturn("hello mockito");

        assertThat(test.hello()).isEqualTo("hello mockito");


        doReturn("1", "2", "3","4").when(test).hello();

        assertThat(test.hello()).isEqualTo("1");
        assertThat(test.hello()).isEqualTo("2");
        assertThat(test.hello()).isEqualTo("3");
        assertThat(test.hello()).isEqualTo("4");
        assertThat(test.hello()).isEqualTo("4");
    }


    public class SpyTest {
        public String hello() {
            System.out.println("real_method_invoked");
            return "hello spy!";
        }
    }



}
