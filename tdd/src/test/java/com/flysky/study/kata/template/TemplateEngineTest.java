package com.flysky.study.kata.template;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TemplateEngineTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TemplateEngine t;

    @Before
    public void setUp() {
        t = new TemplateEngine("${one},${two},${three}");
        t.set("one", "1");
        t.set("two", "2");
        t.set("three", "3");
    }

    @Test
    public void multipleVariable() {
        assertTemplateEvaluatesTo("1,2,3");
    }

    @Test
    public void unknownVariablesAreIgnored() {
        t.set("does_not_exist", "no");
        assertTemplateEvaluatesTo("1,2,3");
    }

    private void assertTemplateEvaluatesTo(String expected) {
        assertThat(t.evaluate()).isEqualTo(expected);
    }

    @Test
    public void missingValueThrowMissingValueError() {
        TemplateEngine t = new TemplateEngine("${one},${two},${three}");
        t.set("one", "1");
        t.set("two", "2");
        exception.expect(MissingValueError.class);
        exception.expectMessage("No value for ${three}");
        t.evaluate();
    }

    @Test
    public void variablesGetProcessedJustOnce() {
        t.set("one", "${one}");
        t.set("two", "${two}");
        t.set("three", "${three}");
        assertThat(t.evaluate()).isEqualTo("${one},${two},${three}");
    }
}
