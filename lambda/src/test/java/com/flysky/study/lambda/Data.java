package com.flysky.study.lambda;

public class Data implements Test.Fraction {
    Integer a = 0;
    Integer b = 0;

    public Data add(Data augend) {
        this.a += augend.a;
        this.b += augend.b;
        return this;
    }

    public int getA() {
        return a;
    }

    public Data setA(int a) {
        this.a = a;
        return this;
    }

    public int getB() {
        return b;
    }

    public Data setB(int b) {
        this.b = b;
        return this;
    }

    @Override
    public String toString() {
        return "Data{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public Number getDivisor() {
        return a;
    }

    float c = 3;

    @Override
    public Number getDividend() {
        return c;
    }
}
