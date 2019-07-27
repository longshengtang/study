package com.flysky.study.kata.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateEngine {

    public TemplateEngine(String template) {
        this.template = template;
    }

    public String evaluate() {
        StringBuilder sb = new StringBuilder();
        List<Segment> segments = new TemplateParse().parseSegments(this.template);
        segments.forEach(segment -> sb.append(segment.evaluate(variables)));
        return sb.toString();
    }

    public void set(String variable, String value) {
        variables.put(variable, value);
    }

    private Map<String, String> variables = new HashMap<>();
    private String template;
}