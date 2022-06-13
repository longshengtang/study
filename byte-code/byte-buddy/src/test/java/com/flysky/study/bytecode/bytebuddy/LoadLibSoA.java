package com.flysky.study.bytecode.bytebuddy;

public class LoadLibSoA {
    static {
        System.loadLibrary("attach");
        System.out.println("loaded attach from " + LoadLibSoA.class);
    }

    public static int get() {
        return 1;
    }
}
