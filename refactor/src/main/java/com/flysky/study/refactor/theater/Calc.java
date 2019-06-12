package com.flysky.study.refactor.theater;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Calc {

    private JsonObject plays;

    public Calc(JsonObject plays) {
        this.plays = plays;
    }

    public String statement(JsonArray invoices, JsonObject plays) {
        long totalAmount = 0;
        long volumeCredits = 0;
        JsonObject invoice = (JsonObject) invoices.get(0);
        String result = "Statement for " + invoice.get("customer").getAsString() + "\n";
        for (Object object : invoice.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            // add volume credits
            volumeCredits += volumeCreditsFor(perf);
            // print line for this order
            result += " " + playFor(perf).get("name").getAsString() + ": " + format(amountFor(perf) / 100) + " (" + perf.get("audience").getAsLong() + " seats)\n";
            totalAmount += amountFor(perf);
        }
        result += "Amount owed is " + format(totalAmount / 100) + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        return result;
    }

    private long volumeCreditsFor(JsonObject perf) {
        long volumeCredits = 0;
        volumeCredits += Math.max(perf.get("audience").getAsLong() - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(playFor(perf).get("type").getAsString()))
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
        switch (playFor(perf).get("type").getAsString()) {
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
