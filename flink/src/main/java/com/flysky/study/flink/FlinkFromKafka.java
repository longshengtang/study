package com.flysky.study.flink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class FlinkFromKafka {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        KafkaSource<String> source = KafkaSource.<String>builder()
//                .setBootstrapServers("10.1.1.11:9093")
//                .setTopics("my-topic")
//                .setGroupId("")
//                .setStartingOffsets(OffsetsInitializer.earliest())
////                .setValueOnlyDeserializer(new SimpleStringSchema())
//                .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(StringDeserializer.class))
//                .build();
//        env.fromSource(source, WatermarkStrategy.noWatermarks(),"test-kafka").print();
//        env.execute();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "10.1.1.11:9093");
//        properties.setProperty("group.id", "test");
        FlinkKafkaConsumer<String> source = new FlinkKafkaConsumer<>("my-topic8", new SimpleStringSchema(), properties);
        env.addSource(source).print()
        ;
        env.execute();
    }
}
