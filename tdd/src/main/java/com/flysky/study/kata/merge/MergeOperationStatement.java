package com.flysky.study.kata.merge;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class MergeOperationStatement {
    public void mergeTotals(Map<String, OperationStatement> result, List<OperationData> teamTotals, BiConsumer<OperationStatement, OperationData> consumer) {
        teamTotals.forEach(d -> consumer.accept(result.computeIfAbsent(d.getDimension(), k -> new OperationStatement()).setDimension(d.getDimension()), d));
    }
}