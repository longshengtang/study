package com.flysky.study.refactor.theater;

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
        result.addProperty("totalAmount",totalAmount(result));
        result.addProperty("totalVolumeCredits",totalVolumeCredits(result));
        return result;
    }

    public void enrichPerformance(JsonArray performances) {
        for (Iterator<JsonElement> it = performances.iterator(); it.hasNext(); ) {
            JsonObject perf = (JsonObject) it.next();
            JsonObject play = playFor(perf);
            perf.add("play", play);
            perf.addProperty("amount", amountFor(perf));
            perf.addProperty("volumeCredits", volumeCreditsFor(perf));
        }
    }
    public long totalAmount(JsonObject invoice) {
        long result = 0;
        for (Object object : invoice.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            result += amountFor(perf);
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

    public long volumeCreditsFor(JsonObject perf) {
        long result = 0;
        result += Math.max(perf.get("audience").getAsLong() - 30, 0);
        if ("comedy".equals(perf.get("play").getAsJsonObject().get("type").getAsString()))
            result += Math.floor(perf.get("audience").getAsLong() / 5);
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

    public long amountFor(JsonObject perf) {
        long result = 0;
        switch (perf.get("play").getAsJsonObject().get("type").getAsString()) {
            case "tragedy":
                result = 40000;
                if (perf.get("audience").getAsLong() > 30) {
                    result += 1000 * (perf.get("audience").getAsLong() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (perf.get("audience").getAsLong() > 20) {
                    result += 10000 + 500 * (perf.get("audience").getAsLong() - 20);
                }
                result += 300 * perf.get("audience").getAsLong();
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }
        return result;
    }
}
