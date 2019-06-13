package com.flysky.study.refactor.theater.calculator;

import com.google.gson.JsonObject;

public class ComedyCalculator extends PerformanceCalculator {
    public ComedyCalculator(JsonObject performance, JsonObject play) {
        super(performance, play);
    }

    @Override
    public long amount() {
        long result = 30000;
        if (getPerformance().get("audience").getAsLong() > 20) {
            result += 10000 + 500 * (getPerformance().get("audience").getAsLong() - 20);
        }
        result += 300 * getPerformance().get("audience").getAsLong();

        return result;
    }

    @Override
    public long volumeCredits() {
        return (long) (super.volumeCredits() + Math.floor(getPerformance().get("audience").getAsLong() / 5));
    }
}
