package com.flysky.study.dp.creational.factory_method;

import org.junit.Test;

public class FactoryMethodTest {

    @Test
    public void test(){
        print(new CanonPrinterFactory());
        print(new HpPrinterFactory());
        print(new EpsonPrinterFactory());
    }

    private void print(PrinterFactory factory) {
        IPrinter printer = factory.createPrinter();
        printer.print();
    }
}
