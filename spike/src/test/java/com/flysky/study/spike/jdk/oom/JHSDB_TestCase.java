package com.flysky.study.spike.jdk.oom;

import java.util.concurrent.TimeUnit;

/**
 * staticObj、instanceObj、localObj存放在哪里？
 */
public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            while(true){
                System.out.println("done");// 这里设一个断点
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
