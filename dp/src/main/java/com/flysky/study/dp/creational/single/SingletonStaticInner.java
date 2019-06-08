package com.flysky.study.dp.creational.single;

public class SingletonStaticInner {

    private SingletonStaticInner() {
        System.out.println("fdsjf;sla");
    }

    public static SingletonStaticInner getInstance() {
        return Instance.instance;
    }

    static class Instance {
        private final static SingletonStaticInner instance = new SingletonStaticInner();
    }
}
