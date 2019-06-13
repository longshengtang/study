package com.flysky.study.refactor.theater;

import com.flysky.study.refactor.theater.calculator.ComedyCalculator;
import com.flysky.study.refactor.theater.calculator.PerformanceCalculator;
import com.flysky.study.refactor.theater.calculator.TragedyCalculator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;

public class CreateStatementData {

    private JsonObject plays;

    public CreateStatementData(JsonObject plays) {
        this.plays = plays;
    }

    public JsonObject createStatementData(JsonArray invoices) {
        JsonObject result = new JsonObject();
        result.add("customer", invoices.get(0).getAsJsonObject().get("customer"));
        JsonArray performances = invoices.get(0).getAsJsonObject().get("performances").getAsJsonArray();
        enrichPerformance(performances);
        result.add("performances", performances);
        result.addProperty("totalAmount", totalAmount(result));
        result.addProperty("totalVolumeCredits", totalVolumeCredits(result));
        return result;
    }

    public void enrichPerformance(JsonArray performances) {
        for (Iterator<JsonElement> it = performances.iterator(); it.hasNext(); ) {
            JsonObject perf = (JsonObject) it.next();
            PerformanceCalculator calculator = createPerformanceCalculator(perf, playFor(perf));
            perf.add("play", calculator.getPlay());
            perf.addProperty("amount", calculator.amount());
            perf.addProperty("volumeCredits", calculator.volumeCredits());
        }
    }

    private PerformanceCalculator createPerformanceCalculator(JsonObject perf, JsonObject play) {
        switch (play.get("type").getAsString()) {
            case "tragedy":
                return new TragedyCalculator(perf, play);
            case "comedy":
                return new ComedyCalculator(perf, play);
            default:
                throw new RuntimeException("unknown type: " + play.get("type").getAsString());
        }
    }

    public long totalAmount(JsonObject invoice) {
        long result = 0;
        for (Object object : invoice.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            result += perf.get("amount").getAsLong();
        }
        return result;
    }

    public long totalVolumeCredits(JsonObject invoice) {
        long result = 0;
        for (Object object : invoice.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            result += perf.get("volumeCredits").getAsLong();
        }
        return result;
    }

    public String usd(long number) {

        NumberFormat format = DecimalFormat.getInstance(Locale.US);
        format.setMinimumFractionDigits(2);

        return format.format(number);
    }


    public JsonObject playFor(JsonObject perf) {
        return (JsonObject) plays.get(perf.get("playID").getAsString());
    }
}
