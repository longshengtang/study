package com.flysky.study.dp.creational.factory_method;

public class CanonPrinterFactory implements PrinterFactory {
    @Override
    public IPrinter createPrinter() {
        return new CanonPrinter();
    }
}
