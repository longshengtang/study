package com.flysky.study.dp.creational.factory_method;

public class EpsonPrinterFactory implements PrinterFactory {
    @Override
    public IPrinter createPrinter() {
        return new EpsonPrinter();
    }
}
