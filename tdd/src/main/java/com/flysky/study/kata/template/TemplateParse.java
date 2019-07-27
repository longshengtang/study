package com.flysky.study.kata.template;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParse {
    public List<Segment> parseSegments(String template) {

        List<Segment> result = new ArrayList<>();

        int index = collectSegments(template, result);

        addTail(template, result, index);

        addPlainTextIfTemplateNoVariable(template, result);

        return result;
    }

    private int collectSegments(String template, List<Segment> result) {
        Matcher matcher = Pattern.compile("\\$\\{[^}]+\\}").matcher(template);
        int index = 0;
        while (matcher.find()) {
            addPlainText(template, result, matcher, index);
            addVariable(template, result, matcher);
            index = matcher.end();
        }
        return index;
    }

    private void addPlainTextIfTemplateNoVariable(String template, List<Segment> result) {
        if (result.size() == 0) {
            result.add(new PlainText(template));
        }
    }

    private void addTail(String template, List<Segment> result, int index) {
        if (index < template.length()) {
            result.add(new PlainText(template.substring(index)));
        }
    }

    private void addVariable(String template, List<Segment> result, Matcher matcher) {
        result.add(new Variable(template.substring(matcher.start() + 2, matcher.end() - 1)));
    }

    private void addPlainText(String template, List<Segment> result, Matcher matcher, int index) {
        if (index != matcher.start()) {
            result.add(new PlainText(template.substring(index, matcher.start())));
        }
    }
}
