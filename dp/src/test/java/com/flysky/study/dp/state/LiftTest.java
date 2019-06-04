package com.flysky.study.dp.state;

import org.junit.Test;

public class LiftTest {

    @Test
    public void test(){
        LiftContext context = new LiftContext();
        System.out.println(context+"\n");
        context.open();
        System.out.println(context+"\n");
        context.close();
        System.out.println(context+"\n");
        context.up();
        System.out.println(context+"\n");
        context.stop();
        System.out.println(context+"\n");
        context.down();
        System.out.println(context+"\n");
    }
}
