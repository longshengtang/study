package com.flysky.study.kata.merge;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MergeOperationStatementTest {

    @Test
    public void twoDateUserTotalsWhenMergeThenTwo() {
        MergeOperationStatement merge = new MergeOperationStatement();
        List<OperationData> userTotals = new ArrayList<>();
        userTotals.add(new OperationData().setDimension("20190312").setTotal(102));
        userTotals.add(new OperationData().setDimension("20190313").setTotal(132));
        Map<String, OperationStatement> result = new HashMap<>();
        merge.mergeTotals(result, userTotals, (s, o) -> s.setNewUserTotal(o.getTotal()));

//        List<OperationStatement> statements = result.values().stream().sorted(Comparator.comparing(s->s.getDimension())).collect(Collectors.toList());
        List<OperationStatement> statements = result.values().stream().sorted(Comparator.comparing(OperationStatement::getDimension)).collect(Collectors.toList());
        Assertions.assertThat(statements.size()).isEqualTo(2);
        Assertions.assertThat(statements.get(0).getNewUserTotal()).isEqualTo(102);
        Assertions.assertThat(statements.get(1).getNewUserTotal()).isEqualTo(132);
    }
}
