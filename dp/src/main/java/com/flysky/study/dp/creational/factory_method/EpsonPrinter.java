package com.flysky.study.dp.creational.factory_method;

public class EpsonPrinter implements IPrinter {
    @Override
    public void print() {
        System.out.println("爱普生打印机打印");
    }
}
