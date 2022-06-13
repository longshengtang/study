package com.flysky.study.lambda.count;

import java.util.List;

public class SimpleFractionCalculator implements Calculator {

    @Override
    public Column[] columns(List<Metadata> compositeMetadatas) {
        SimpleFraction result = compositeMetadatas.stream().map(SimpleFraction::new).reduce(
                new SimpleFraction(),
                SimpleFraction::add);
        return new Column[]{result};
    }
}