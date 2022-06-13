package com.flysky.study.dp.behavioral.visitor.dispatch;

/**
 * @author LONGSHENGTANG048
 * @since 2022/4/20
 */
public class Dispatch {
    static class Tencent{}
    static class QQ extends Tencent{}
    static class Wechat extends Tencent{}
    public static class Father{
        public void choice(Tencent tencent) {
            System.out.println("father choose tencent");
        }
        public void choice(QQ qq) {
            System.out.println("father choose qq");
        }
        public void choice(Wechat wechat) {
            System.out.println("father choose wechat");
        }
    }
    public static class Son extends Father{
        public void choice(Tencent tencent) {
            System.out.println("son choose tencent");
        }
        public void choice(QQ qq) {
            System.out.println("son choose qq");
        }
        public void choice(Wechat wechat) {
            System.out.println("son choose wechat");
        }
    }

    public static void main(String[] args) {
        testStaticDispatchAndOverload();
//        testDynamicDispatchAndOverride();
    }

    public static void testStaticDispatchAndOverload() {
        Father father=new Father();
        Father son=new Son();
        QQ qq = new QQ();
        father.choice(qq);
        Wechat wechat = new Wechat();
        son.choice(wechat);
    }
    public static void testDynamicDispatchAndOverride() {
        Father son=new Son();
        Wechat wechat = new Wechat();
        son.choice(wechat);
    }

}
