package com.flysky.study.flink;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkFromFile {
    public static void main(String[] args) throws Exception {
        ParameterTool pt = ParameterTool.fromArgs(args);
        String file = pt.get("file", "/Users/longlong/flysky/code/study/flink/src/main/resources/hello.txt");
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        System.out.println("env.getParallelism() = " + env.getParallelism());
        DataStream<String> dataStream = env.readTextFile(file);
        dataStream.flatMap(new WordCountFlatMap())
                .keyBy(WordCount::getWord)
                .sum("count")
                .print()
        ;
        env.execute();
    }
}
