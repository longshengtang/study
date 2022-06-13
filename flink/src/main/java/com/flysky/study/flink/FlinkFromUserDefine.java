package com.flysky.study.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FlinkFromUserDefine {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        System.out.println("env.getParallelism() = " + env.getParallelism());
        DataStream<Temperature> dataStream = env.addSource(new MySource());
        dataStream.print();
        env.execute();

    }

    static public class MySource implements SourceFunction<Temperature> {

        private volatile boolean running = true;

        @Override
        public void run(SourceContext<Temperature> ctx) throws Exception {
            Random random = new Random();
            while (running) {
                ctx.collectWithTimestamp(new Temperature(random.nextGaussian() + 24.0, System.currentTimeMillis()), System.currentTimeMillis());
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }

        @Override
        public void cancel() {
            running = false;
        }
    }
}
