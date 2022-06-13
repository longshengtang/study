package com.flysky.study.dp.behavioral.visitor.dispatch;

import org.junit.Test;

public class StaticDispatchTest {
    StaticDispatch staticDispatch = new StaticDispatch();

    @Test
    public void testSayHello() throws Exception {
        staticDispatch.sayHello(new StaticDispatch.Human());
    }

    @Test
    public void testSayHello2() throws Exception {
        staticDispatch.sayHello(new StaticDispatch.Man());
    }

    @Test
    public void testSayHello3() throws Exception {
        staticDispatch.sayHello(new StaticDispatch.Woman());
    }

    @Test
    public void testMain() throws Exception {
        StaticDispatch.main(new String[]{"args"});
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
