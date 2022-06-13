package com.flysky.study.lambda.count;

import java.util.List;

public class MultipleColumnCalculator implements Calculator {
    @Override
    public Column[] columns(List<Metadata> compositeMetadatas) {

        MultipleColumnOriginalData result = compositeMetadatas.stream().map(MultipleColumnOriginalData::new)
                .reduce(new MultipleColumnOriginalData(), MultipleColumnOriginalData::add);

        return result.columns();
    }
}
