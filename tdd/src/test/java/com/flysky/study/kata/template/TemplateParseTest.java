package com.flysky.study.kata.template;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TemplateParseTest {

    private TemplateParse p;

    @Before
    public void setUp() {
        p = new TemplateParse();
    }

    @Test
    public void emptyTemplateRendersAsEmptyString() {
        assertSegment(p.parseSegments(""), new PlainText(""));
    }

    @Test
    public void templateWithOnlyPlainText() {
        assertSegment(p.parseSegments("plain text only"), new PlainText("plain text only"));
    }

    @Test
    public void templateMultipleVariableIntoSegmentObjects() {
        assertSegment(p.parseSegments("${z}x ${a} b ${c} d${e}")
                , new Variable("z")
                , new PlainText("x "), new Variable("a")
                , new PlainText(" b "), new Variable("c")
                , new PlainText(" d")
                , new Variable("e")
        );
    }

    @Test
    public void test() {
        assertSegment(p.parseSegments("${one},${two},${three}")
                , new Variable("one")
                , new PlainText(",")
                , new Variable("two")
                , new PlainText(",")
                , new Variable("three")
        );
    }

    private void assertSegment(List<Segment> segments, Object... expected) {
        assertThat(segments.size()).isEqualTo(expected.length);
        assertThat(Arrays.asList(expected)).isEqualTo(segments);
    }
}
