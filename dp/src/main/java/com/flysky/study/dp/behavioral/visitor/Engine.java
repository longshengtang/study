package com.flysky.study.dp.behavioral.visitor;

public class Engine implements Element {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
