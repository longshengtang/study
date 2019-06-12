package com.flysky.study.refactor.theater;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.junit.Test;

public class FileReaderTest {

    @Test
    public void parse() {

        String file = "/Users/longlong/flysky/code/study/refactor/src/main/java/com/flysky/study/refactor/theater/invoices.json";
        String result = FileReader.parse(file);

        System.out.println(result);
        assertNotNull("文件内容不能为空",result);
        assertNotEquals(result,"");
    }
    @Test
    public void parseGson() {

        String file = "/Users/longlong/flysky/code/study/refactor/src/main/java/com/flysky/study/refactor/theater/invoices.json";
        String result = FileReader.parse(file);

        Gson gson=new Gson();
        JsonArray jsonObject = gson.fromJson(result,JsonArray.class);

        System.out.println(jsonObject);
    }
}