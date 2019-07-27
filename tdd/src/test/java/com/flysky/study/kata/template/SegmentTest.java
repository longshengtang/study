package com.flysky.study.kata.template;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;

public class SegmentTest {

    @Test
    public void emptyTemplateEvaluateIsEmpty() {
        Assertions.assertThat(new PlainText("").evaluate(Collections.emptyMap())).isEqualTo("");
    }
    @Test
    public void plainTextTemplateEvaluateIsPlainText() {
        Assertions.assertThat(new PlainText("plain text only").evaluate(Collections.emptyMap())).isEqualTo("plain text only");
    }
    @Test
    public void variableEvaluateToValue() {
        Assertions.assertThat(new Variable("name").evaluate(Collections.singletonMap("name","中国"))).isEqualTo("中国");
    }
}
