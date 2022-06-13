package com.flysky.study.lambda;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {

    @org.junit.Test
    public void should_split() {
        Stream.iterate(0, n -> n + 1).limit(5).forEach(d -> {

        });

    }

    @org.junit.Test
    public void should_tow() {

        List<Data> datas = Arrays.asList(
//                new Data().setA(4).setB(5),new Data().setA(3)
        );
        Optional<Data> result = datas.stream().reduce(Data::add);
        System.out.println("result = " + result);


    }

    @org.junit.Test
    public void test_consumer() {
        function_consumer(Test::trigger_gc);
    }

    private static void trigger_gc(Boolean o) {
        System.out.println("------gc=="+o);
        System.gc();
    }

    public static void function_consumer(Consumer<Boolean> consumer) {
        consumer.accept(true);
    }

//    public static void trigger_gc() {
//        System.out.println("------gc");
//        System.gc();
//    }

    interface Fraction<T extends Number, S extends Number> {
        default T getDivisor() {
            return null;
        }

        default S getDividend() {
            return null;
        }
    }

    interface Metadata<K, T extends Number, S extends Number> {
        Date getRowKey();

        K getTypeKey();

        default T getDivisor() {
            return null;
        }

        default S getDividend() {
            return null;
        }
    }


}


