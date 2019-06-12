package com.flysky.study.dp.behavioral.visitor;

public class Engineer implements Visitor {
    protected String name;

    public Engineer(String name) {
        this.name = name;
    }

    public void visit(Wheel wheel) {
        System.out.println("Check " + wheel.getName() + "!");
    }

    public void visit(Engine engine) {
        System.out.println("Check Engine!");
    }

    public void visit(Body body) {
        System.out.println("Check Body!");
    }

    public void visit(Car car) {
        System.out.println(name + " Check Car!");
    }
}
