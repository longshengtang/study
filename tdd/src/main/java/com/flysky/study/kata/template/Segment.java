package com.flysky.study.kata.template;

import java.util.Map;

public interface Segment {
    String evaluate(Map<String, String> variables);
}
