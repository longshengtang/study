package com.flysky.study.dp.behavioral.visitor;

public class Body implements Element{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
