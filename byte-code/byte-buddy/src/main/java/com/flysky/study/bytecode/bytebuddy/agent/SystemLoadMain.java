package com.flysky.study.bytecode.bytebuddy.agent;

public class SystemLoadMain {
    public static void main(String[] args) {
        ThreadLocal<Object> local = new ThreadLocal<>();
        local.set("hello word--"+SystemLoadAdvice.class);
        System.out.println("start2---");
        System.load("/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/lib/libattach.dylib");
        System.out.println("end2---");
    }
}
