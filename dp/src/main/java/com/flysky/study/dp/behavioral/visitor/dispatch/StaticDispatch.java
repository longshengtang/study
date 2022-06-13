package com.flysky.study.dp.behavioral.visitor.dispatch;

/**
 * @author LONGSHENGTANG048
 */
public class StaticDispatch {
    static class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Human human) {
        System.out.println("人类");
    }
    public void sayHello(Man man) {
        System.out.println("男人");
    }
    public void sayHello(Woman woman) {
        System.out.println("女人");
    }

    public static void main(String[] args) {
        //从编译结果可以看出，在编译阶段：
        //1、编译阶段已经确定了签名
        //2、签名的确定依据的是变量的静态类型而非实际类型
        //总结：依据变量的静态类型来决定重载方法的签名，而静态类型在编译时可知且确定，因此编译时确定了方法签名
        //编译时刻，方法签名已经确定，确定的依据是静态类型而非实际类型；运行时刻，不会再根据变量的实际类型重新选择方法签名。
        Human man=new Man();
        Human woman=new Woman();

        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}
