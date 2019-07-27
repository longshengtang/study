package com.flysky.study.kata.frequency;

import java.util.*;
import java.util.stream.Collectors;

public class Frequency {
    public String count(String in) {
        if ("".equals(in)) {
            return "";
        }

        return getString3(in);
    }

    private String getString3(String in) {

        StringBuilder result = new StringBuilder();
        Arrays.stream(in.split(" ")).collect(Collectors.groupingBy(String::toString, TreeMap::new, Collectors.counting())).forEach((k, v) -> result.append(k + " " + v + "\n"));

        return result.toString();
    }

    private String getString2(String in) {
        Map<String, List<String>> collect = Arrays.stream(in.split(" ")).collect(Collectors.toMap(
                s -> s,
                s -> Collections.singletonList(s),
                (a, b) -> {
                    List<String> r = new ArrayList<>(a);
                    r.addAll(b);
                    return r;

                },
                TreeMap::new
        ));


        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, List<String>> entry : collect.entrySet()) {
            result.append(entry.getKey() + " " + entry.getValue().size()).append("\n");
        }

        return result.toString();
    }

    private String getString(String in) {
        Map<String, Integer> wordCounts = new TreeMap<>();

        Arrays.stream(in.split(" ")).forEach(s -> {
            Integer count = wordCounts.getOrDefault(s, 0);
            wordCounts.put(s, ++count);
        });


        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            result.append(entry.getKey() + " " + entry.getValue()).append("\n");
        }


        return result.toString();
    }
}
