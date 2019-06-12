package com.flysky.study.refactor.theater;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Calc {

    public String statement(JsonArray invoices, JsonObject plays) {
        long totalAmount = 0;
        long volumeCredits = 0;
        JsonObject invoice = (JsonObject) invoices.get(0);
        String result = "Statement for " + invoice.get("customer").getAsString() + "\n";
        NumberFormat format = DecimalFormat.getInstance(Locale.US);
        format.setMinimumFractionDigits(2);
        for (Object object : invoice.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            JsonObject play = (JsonObject) plays.get(perf.get("playID").getAsString());
            long thisAmount = amountFor(perf, play);
            // add volume credits
            volumeCredits += Math.max(perf.get("audience").getAsLong() - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.get("type").getAsString()))
                volumeCredits += Math.floor(perf.get("audience").getAsLong() / 5);
            // print line for this order
            result += " " + play.get("name").getAsString() + ": " + format.format(thisAmount / 100) + " (" + perf.get("audience").getAsLong() + " seats)\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + format.format(totalAmount / 100) + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        return result;
    }

    private long amountFor(JsonObject perf, JsonObject play) {
        long thisAmount = 0;
        switch (play.get("type").getAsString()) {
            case "tragedy":
                thisAmount = 40000;
                if (perf.get("audience").getAsLong() > 30) {
                    thisAmount += 1000 * (perf.get("audience").getAsLong() - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (perf.get("audience").getAsLong() > 20) {
                    thisAmount += 10000 + 500 * (perf.get("audience").getAsLong() - 20);
                }
                thisAmount += 300 * perf.get("audience").getAsLong();
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }
        return thisAmount;
    }
}
