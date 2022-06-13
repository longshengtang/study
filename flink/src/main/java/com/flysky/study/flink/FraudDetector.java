package com.flysky.study.flink;

import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

public class FraudDetector extends KeyedProcessFunction<Long, Transaction, Alert> {
    private static final long serialVersionUID = 1L;

    private static final double SMALL_AMOUNT = 1.00;
    private static final double LARGE_AMOUNT = 500.00;
    private static final long ONE_MINUTE = 60 * 1000;

    @Override
    public void processElement(Transaction value, Context ctx, Collector<Alert> out) throws Exception {
        Alert alert = new Alert();
        alert.setId(value.getAccountId());
        out.collect(alert);
    }
}
