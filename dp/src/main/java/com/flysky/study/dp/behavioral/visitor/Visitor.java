package com.flysky.study.dp.behavioral.visitor;

public interface Visitor {
    void visit(Wheel wheel);

    void visit(Engine engine);

    void visit(Body body);

    void visit(Car car);
}
