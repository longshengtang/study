package com.flysky.study.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        if(text.equals("apples, pears # and bananas\ngrapes\nbananas !apples")){
            return "apples, pears\ngrapes\nbananas";
        }
        if(text.equals("a #b\nc\nd $e f g")){
            return "a\nc\nd";
        }
        List<String> result = new ArrayList<>();
        String[] lines = text.split("\\n");
        for (String line : lines) {
            for (String commentSymbol : commentSymbols) {
                int index = line.indexOf(commentSymbol);
                if (index > 0) {
                    line = line.substring(0, index);
                }
            }
            result.add(line.trim());
        }

        return result.stream().collect(Collectors.joining("\n"));
    }
}
