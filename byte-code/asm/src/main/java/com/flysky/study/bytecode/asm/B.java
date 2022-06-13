package com.flysky.study.bytecode.asm;

import java.util.concurrent.atomic.AtomicInteger;

public class B {
//    int i =0;
    private AtomicInteger i=new AtomicInteger(0);
    public void say() {
//        i=i+1;
//        hello();
        i.incrementAndGet();
    }

//    public void hello() {
//        System.out.println("hello");
//    }
}
