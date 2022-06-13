package com.flysky.study.flink;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TransactionSource implements SourceFunction<Transaction> {

    private volatile boolean running = true;

    @Override
    public void run(SourceContext<Transaction> ctx) throws Exception {
        Random random = new Random();
        while (running) {
            Transaction transaction = new Transaction();
            transaction.setAccountId((long) random.nextInt(100));
            ctx.collect(transaction);
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    @Override
    public void cancel() {
        this.running = false;
    }
}
