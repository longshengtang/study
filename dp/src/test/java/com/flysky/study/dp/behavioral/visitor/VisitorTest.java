package com.flysky.study.dp.behavioral.visitor;

import org.junit.Test;

public class VisitorTest {
    @Test
    public void test(){
        Visitor visitor = new Engineer("flysky");
        Element element = new Car();
        element.accept(visitor);
    }
}
