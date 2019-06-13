package com.flysky.study.refactor.theater;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;

public class Calc {

    private JsonObject plays;

    public Calc(JsonObject plays) {
        this.plays = plays;
    }

    public String statement(JsonArray invoices) {
        JsonObject statementData = new JsonObject();
        statementData.add("customer", invoices.get(0).getAsJsonObject().get("customer"));
        JsonArray performances = invoices.get(0).getAsJsonObject().get("performances").getAsJsonArray();
        enrichPerformance(performances);
        statementData.add("performances", performances);
        return renderPlainText(statementData);
    }

    private void enrichPerformance(JsonArray performances) {
        for (Iterator<JsonElement> it = performances.iterator(); it.hasNext(); ) {
            JsonObject perf = (JsonObject) it.next();
            JsonObject play = playFor(perf);
            perf.add("play", play);
            perf.addProperty("amount", amountFor(perf));
            perf.addProperty("volumeCredits", volumeCreditsFor(perf));

        }
    }

    private String renderPlainText(JsonObject data) {
        String result = "Statement for " + data.get("customer").getAsString() + "\n";
        for (Object object : data.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            result += " " + perf.get("play").getAsJsonObject().get("name").getAsString() + ": " + format(perf.get("amount").getAsLong() / 100) + " (" + perf.get("audience").getAsLong() + " seats)\n";
        }
        result += "Amount owed is " + format(totalAmount(data) / 100) + "\n";
        result += "You earned " + totalVolumeCredits(data) + " credits\n";
        return result;
    }

    private long totalAmount(JsonObject invoice) {
        long result = 0;
        for (Object object : invoice.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            result += amountFor(perf);
        }
        return result;
    }

    private long totalVolumeCredits(JsonObject invoice) {
        long volumeCredits = 0;
        for (Object object : invoice.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            volumeCredits += perf.get("volumeCredits").getAsLong();
        }
        return volumeCredits;
    }

    private long volumeCreditsFor(JsonObject perf) {
        long volumeCredits = 0;
        volumeCredits += Math.max(perf.get("audience").getAsLong() - 30, 0);
        if ("comedy".equals(perf.get("play").getAsJsonObject().get("type").getAsString()))
            volumeCredits += Math.floor(perf.get("audience").getAsLong() / 5);
        return volumeCredits;
    }

    private String format(long number) {

        NumberFormat format = DecimalFormat.getInstance(Locale.US);
        format.setMinimumFractionDigits(2);

        return format.format(number);
    }


    private JsonObject playFor(JsonObject perf) {
        return (JsonObject) plays.get(perf.get("playID").getAsString());
    }

    private long amountFor(JsonObject perf) {
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
