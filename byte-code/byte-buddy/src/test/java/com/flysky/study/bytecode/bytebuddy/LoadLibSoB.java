package com.flysky.study.bytecode.bytebuddy;

public class LoadLibSoB {
    static {
        System.loadLibrary("attach");
        System.out.println("loaded attach from " + LoadLibSoB.class);
    }
}
