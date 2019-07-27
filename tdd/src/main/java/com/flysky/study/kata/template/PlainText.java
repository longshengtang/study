package com.flysky.study.kata.template;

import java.util.Map;

public class PlainText implements Segment {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        return this.text.equals(((PlainText) obj).text);
    }

    @Override
    public String toString() {
        return "PlainText{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return text;
    }
}
