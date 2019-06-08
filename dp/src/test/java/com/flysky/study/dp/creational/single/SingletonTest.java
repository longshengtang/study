package com.flysky.study.dp.creational.single;

import org.junit.Test;

public class SingletonTest {
    @Test
    public void testDoubleCheck() {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
    @Test
    public void testStaticInner() {
        System.out.println(SingletonStaticInner.getInstance());
        System.out.println(SingletonStaticInner.getInstance());
    }
}
