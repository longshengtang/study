package com.flysky.study.lambda.count;

import java.util.Date;

public interface Metadata<T> extends Fraction {
    Date getRowKey();

    T getTypeKey();

    @Override
    default Number getDivisor() {
        return null;
    }

    @Override
    default Number getDividend() {
        return null;
    }
}
