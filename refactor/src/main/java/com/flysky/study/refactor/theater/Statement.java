package com.flysky.study.refactor.theater;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Statement {

    private CreateStatementData statementData;

    public Statement(JsonObject plays) {
        statementData=new CreateStatementData(plays);
    }

    public String statement(JsonArray invoices) {
        return renderPlainText(statementData.createStatementData(invoices));
    }

    private String renderPlainText(JsonObject data) {
        String result = "Statement for " + data.get("customer").getAsString() + "\n";
        for (Object object : data.getAsJsonArray("performances")) {
            JsonObject perf = (JsonObject) object;
            result += " " + perf.get("play").getAsJsonObject().get("name").getAsString() + ": " + statementData.usd(perf.get("amount").getAsLong() / 100) + " (" + perf.get("audience").getAsLong() + " seats)\n";
        }
        result += "Amount owed is " + statementData.usd(data.get("totalAmount").getAsLong() / 100) + "\n";
        result += "You earned " + data.get("totalVolumeCredits").getAsLong() + " credits\n";
        return result;
    }
}
