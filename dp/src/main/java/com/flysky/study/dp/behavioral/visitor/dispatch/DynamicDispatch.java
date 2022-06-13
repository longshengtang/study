package com.flysky.study.dp.behavioral.visitor.dispatch;

/**
 * @author LONGSHENGTANG048
 */
 public class DynamicDispatch {
    static abstract class Human{
        abstract public void sayHello();
    }
    static class Man extends Human{
        public void sayHello() {
            System.out.println("男人");
        }
    }
    static class Woman extends Human{
        public void sayHello() {
            System.out.println("女人");
        }
    }
    public static void main(String[] args) {
        //说明了在编译阶段：
        //1、相同的静态类型，指向不同的实际类型，调用同一个方法，运行结果呈现多态
        //2、从编译结果（即虚拟机指令相同）无法分析出原因
        Human man=new Man();
        Human woman=new Woman();
        man.sayHello();
        woman.sayHello();
    }
}
