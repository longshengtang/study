package com.flysky.study.refactor.theater;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;

public class StatementTest {

    @Test
    public void statement() {
        commTest("invoices_11_22_33.json");
        commTest("invoices_30_40_50.json");
        commTest("invoices_55_35_40.json");
    }

    private void commTest(String invoiceName) {
        String base="/Users/longlong/flysky/code/study/refactor/src/main/java/com/flysky/study/refactor/theater/";
        Gson gson=new Gson();
        JsonArray invoices = gson.fromJson(FileReader.parse(base+invoiceName),JsonArray.class);
        JsonObject plays = gson.fromJson(FileReader.parse(base+"plays.json"),JsonObject.class);
        String expected = invoices.get(0).getAsJsonObject().get("result").getAsString();

        Statement statement =new Statement(plays);
        String result = statement.statement(invoices);
        Assert.assertEquals("不一样",expected,result);
//        System.out.println("===================");
//        System.out.println(result);
    }
}