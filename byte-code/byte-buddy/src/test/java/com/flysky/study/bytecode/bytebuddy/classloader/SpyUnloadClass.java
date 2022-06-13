package com.flysky.study.bytecode.bytebuddy.classloader;

public class SpyUnloadClass {

    public static void main(String[] args) {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        try {
            // 一般尽量采用这种形式
            demo1 = Class.forName("com.flysky.study.bytecode.bytebuddy.classloader.PartionOnStack");
        } catch (Exception e) {
            e.printStackTrace();
        }
        demo2 = new PartionOnStack().getClass();
        demo3 = PartionOnStack.class;

    }


}
