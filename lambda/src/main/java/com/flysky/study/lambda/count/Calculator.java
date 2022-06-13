package com.flysky.study.lambda.count;

import java.util.List;

public interface Calculator {
    Column[] columns(List<Metadata> compositeMetadatas);
}
