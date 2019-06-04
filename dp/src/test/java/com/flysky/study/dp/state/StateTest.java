package com.flysky.study.dp.state;

import org.junit.Test;

public class StateTest {
    @Test
    public void test() {
        LiftContext context = new LiftContext();
        context.open();
        context.close();
        context.up();
        context.stop();
        context.down();
    }

}
