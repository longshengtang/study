package com.flysky.study.lambda.count;

public interface Fraction<D extends Number,F extends Number> {
    D getDivisor();
    F getDividend();
}
