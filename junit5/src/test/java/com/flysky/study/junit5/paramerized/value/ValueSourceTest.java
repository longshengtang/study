package com.flysky.study.junit5.paramerized.value;

import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueSourceTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, /*5,*/ 6, 8/*, 9*/})
//    @ValueSource(ints = {2, 4, /*5,*/ 6, 8/*, 9*/})
    public void should_be_even(int num) {
        assertThat(num % 2).isEqualTo(0);
    }

    @ParameterizedTest
    @Timeout(2)
    @MethodSource(value = "mapGenerator")
    public void should(Map<String, String> map) {
        System.out.println("-------" + map);
        assertThat(map).doesNotContainKeys("a4", "22", "32");
    }

    @ParameterizedTest
    @MethodSource(value = "treeData")
    public void construct_tree(Tuple t) {
        int[] src = (int[]) t.toList().get(0);
        int[] target = (int[]) t.toList().get(1);
        int[] actual={};
        //assertThat()
    }

    static Stream<Map<String, String>> mapGenerator() {
        return Stream.of(
                Collections.singletonMap("a", "a")
//                , Collections.singletonMap("b", "b")
//                , Collections.singletonMap("c", "c")
//                , Collections.singletonMap("d", "d")
        );
    }
    static Stream<Tuple> treeData() {
        return Stream.of(
                Tuple.tuple(new int[]{1},new int[]{1})
//                ,
//                Tuple.tuple(new int[]{1,2,3},new int[]{1,2,3})
        );
    }

}
