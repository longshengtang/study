package com.flysky.study.spring.test.context;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class BaseTest {
    @Test
    public void should_be_running() {
        String str = context.toString();
        if (print) {
            System.out.println("str = " + str);
            print = false;
        }
        System.out.println(this.getClass().getSimpleName() + "的context实例:" + str.substring(str.indexOf("@")));
    }

    private static boolean print = true;

    @Autowired
    private ApplicationContext context;
}
