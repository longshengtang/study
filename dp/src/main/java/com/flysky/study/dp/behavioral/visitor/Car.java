package com.flysky.study.dp.behavioral.visitor;

public class Car implements Element {
    private Engine engine = new Engine();
    private Body body = new Body();
    private Wheel[] wheels = {new Wheel("Font left"), new Wheel("Front right"), new Wheel("Back left"), new Wheel("Back right")};

    public void accept(Visitor v) {
        v.visit(this);
        engine.accept(v);
        body.accept(v);
        for (int i = 0; i < wheels.length; i++) {
            wheels[i].accept(v);
        }
    }
}

