package com.flysky.study.kata.template;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTemplateEnginePerformance {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TemplateEngine t;

    @Before
    public void setUp() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz_" + i).append(" ");
        }

        for (int i = 0; i < 20; i++) {
            sb.append("${abcdefghijklmnopqrstuvwxyz_" + i + "}").append(",");
        }
        t = new TemplateEngine(sb.toString());
        for (int i = 0; i < 20; i++) {
            t.set("abcdefghijklmnopqrstuvwxyz_" + i, i + "");
        }
    }

    @Test(timeout = 200)
    public void templateWith100WordsAnd20Variables() {
        t.evaluate();
    }

}
