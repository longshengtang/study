package com.flysky.study.refactor.theater.calculator;

import com.google.gson.JsonObject;

public class PerformanceCalculator {
    private JsonObject performance;
    private JsonObject play;

    public PerformanceCalculator(JsonObject performance, JsonObject play) {
        this.performance = performance;
        this.play = play;
    }

    public JsonObject getPerformance() {
        return performance;
    }

    public void setPerformance(JsonObject performance) {
        this.performance = performance;
    }

    public JsonObject getPlay() {
        return play;
    }

    public void setPlay(JsonObject play) {
        this.play = play;
    }


    public long amount() {
        switch (this.play.get("type").getAsString()) {
            case "tragedy":
                throw new RuntimeException("bad thing");
            case "comedy":
                throw new RuntimeException("bclass responsibility");
            default:
                throw new RuntimeException("unknown type: "+this.play.get("type").getAsString());
        }
    }


    public long volumeCredits() {
        return Math.max(performance.get("audience").getAsLong() - 30, 0);
    }
}
