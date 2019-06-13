package com.flysky.study.refactor.theater.calculator;

import com.google.gson.JsonObject;

public class TragedyCalculator extends PerformanceCalculator {
    public TragedyCalculator(JsonObject performance, JsonObject play) {
        super(performance, play);
    }

    @Override
    public long amount() {
        long result = 40000;
        if (getPerformance().get("audience").getAsLong() > 30) {
            result += 1000 * (getPerformance().get("audience").getAsLong() - 30);
        }
        return result;
    }
}
