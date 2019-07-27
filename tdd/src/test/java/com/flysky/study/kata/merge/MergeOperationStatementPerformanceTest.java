package com.flysky.study.kata.merge;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MergeOperationStatementPerformanceTest {

    private MergeOperationStatement merge;
    private List<OperationData> userTotals;
    private int len;

    @Before
    public void setUp() {
        merge = new MergeOperationStatement();
        userTotals = new ArrayList<>();
        long start = 100000000;
        len = 10000;
        for (int i = 0; i < len; i++) {
            userTotals.add(new OperationData().setDimension(start + i + "").setTotal(i));
        }
    }

    @Test(timeout = 200)
    public void test10000Performance() {
        Map<String, OperationStatement> result = new HashMap<>();
        merge.mergeTotals(result, userTotals, (statement, data) -> statement.setNewUserTotal(data.getTotal()));
        Assertions.assertThat(result.values().stream().sorted(Comparator.comparing(OperationStatement::getDimension)).collect(Collectors.toList()).size()).isEqualTo(len);
    }
}
