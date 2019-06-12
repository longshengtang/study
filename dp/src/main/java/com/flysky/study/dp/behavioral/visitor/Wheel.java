package com.flysky.study.dp.behavioral.visitor;

public class Wheel implements Element{

    public Wheel(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
