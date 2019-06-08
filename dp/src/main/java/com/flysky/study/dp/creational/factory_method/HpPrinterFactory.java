package com.flysky.study.dp.creational.factory_method;

public class HpPrinterFactory implements PrinterFactory {
    @Override
    public IPrinter createPrinter() {
        return new HpPrinter();
    }
}
