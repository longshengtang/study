package com.flysky.study.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public List<String> duplicatedWords(String lines) {

        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b([a-zA-Z]+)\\b\\s*\\1").matcher(lines);
        matcher = Pattern.compile("(\\w+)\\s*\\1").matcher(lines);
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }
}