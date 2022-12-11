package com.flysky.study.bytecode.bytebuddy.F;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main方法执行");
        tt("55555");
        Thread.sleep(1000);
    }

    private static void tt(String a) {
        System.out.println("参数---a=" + a);
    }
}
