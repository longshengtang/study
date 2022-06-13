package com.flysky.study.flink;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkFromSocket {
    public static void main(String[] args) throws Exception {
        ParameterTool pt = ParameterTool.fromArgs(args);
        String host = pt.get("host", "127.0.0.1");
        int port = pt.getInt("port", 7777);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        System.out.println("env.getParallelism() = " + env.getParallelism());
//        DataStream<String> dataStream = env.readTextFile("/Users/longlong/flysky/code/study/flink/src/main/resources/hello.txt");
        DataStream<String> dataStream = env.socketTextStream(host, port);

        dataStream.flatMap(new WordCountFlatMap())
                .keyBy(WordCount::getWord)
                .sum("count")
                .print()
        ;
        env.execute();
    }
}
