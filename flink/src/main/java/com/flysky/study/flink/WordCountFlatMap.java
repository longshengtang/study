package com.flysky.study.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class WordCountFlatMap implements FlatMapFunction<String, WordCount> {
    public void flatMap(String value, Collector<WordCount> out) throws Exception {
        String[] words = value.split(" |,");
        for (String word : words) {
            out.collect(new WordCount(word, 1));
        }
    }
}
