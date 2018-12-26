package com.flysky.study.poi;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.List;

public class POITest {


    public static void main(String[] args) {
        test2();
//        test3();
    }

    private static void test3() {
        Excel07SaxReader reader = new Excel07SaxReader(createRowHandler());

        long s = System.nanoTime();
        reader.read("/Users/longlong/flysky/tmp/xxx.xlsx", -1);
        long e = System.nanoTime();
        System.out.println("结束啦--" + (e - s));

    }

    private static RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
                System.out.println(sheetIndex+"--"+rowIndex);
//                Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
            }
        };
    }

    private static void test2() {

        BigExcelWriter writer = ExcelUtil.getBigWriter("/Users/longlong/flysky/tmp/xxx.csv");

        long s = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
//        for (int i = 0; i < 10; i++) {
            List<?> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
            List<?> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
            List<?> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
            List<?> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
            List<?> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
            List<?> row6 = CollUtil.newArrayList("aa5", "bb5", "cc5", "dd5");
            List<?> row7 = CollUtil.newArrayList("aa6", "bb6", "cc6", "dd6");
            List<?> row8 = CollUtil.newArrayList("aa7", "bb7", "cc7", "dd7");
            List<?> row9 = CollUtil.newArrayList("aa8", "bb8", "cc8", "dd8");
            List<?> row10 = CollUtil.newArrayList("aa9", "bb9", "cc9", "dd9");

            List<List<?>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10);
            // 一次性写出内容，使用默ßß认样式
            writer.write(rows);
        }
        long e = System.nanoTime();
        System.out.println(e - s);

        // 关闭writer，释放内存
        writer.close();
    }

    private static void test() {
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("/Users/longlong/flysky/tmp/writeBeanTest.xlsx");

        //自定义标题别名
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("score", "分数");
        writer.addHeaderAlias("isPass", "是否通过");
        writer.addHeaderAlias("examDate", "考试时间");

        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "一班成绩单");

        TestBean bean1 = new TestBean();
        bean1.setName("张三");
        bean1.setAge(22);
        bean1.setPass(true);
        bean1.setScore(66.30);
        bean1.setExamDate(DateUtil.date());

        TestBean bean2 = new TestBean();
        bean2.setName("李四");
        bean2.setAge(28);
        bean2.setPass(false);
        bean2.setScore(38.50);
        bean2.setExamDate(DateUtil.date());

        List<TestBean> rows = CollUtil.newArrayList(bean1, bean2);

        // 一次性写出内容，使用默认样式
        writer.write(rows);
        // 关闭writer，释放内存
        writer.close();
    }
}
