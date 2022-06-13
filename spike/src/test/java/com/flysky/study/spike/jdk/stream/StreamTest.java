package com.flysky.study.spike.jdk.stream;

public class StreamTest {
//    class p.X {
////        String x = "3";
////
////        @Override
////        public String toString() {
////            return "p.X{" +
////                    "x='" + x + '\'' +
////                    '}';
////        }
//    }
//
//    class U {
//        String a;
////        p.X u = new p.X();
//
//        @Override
//        public String toString() {
//            return "U{" +
//                    "a='" + a + '\'' +
////                    ", u=" + u +
//                    '}';
//        }
//    }

//    @Test
    public void filter_modify_invalid() {
//        U uu = new U();
//        uu.a = "f";
//        Stream<U> stream = Stream.of(uu);
//        List<U> us = new ArrayList<>();
//        us.add(uu);
//        stream = Arrays.asList(uu).stream();
//        stream = us.stream();
//        List<U> list = stream
//                .filter(u -> {
//                    u.a = "u";
//                    return true;
//                })
////                .peek(System.out::println)
//                .map(f -> {
//                    f.a = "abc";
////                    f.u.x = "xyz";
//                    return f;
//                })
//                .collect(Collectors.toList());
//        List<U> r = list.stream().map(x -> {
//            x.a = "ffff";
//            return x;
//        }).collect(Collectors.toList());
//        System.out.println("list = " + list);
//        System.out.println("uu = " + uu);
//        System.out.println("r = " + r);

//        Runnable runnable = () -> System.out.println("hello");
//        runnable.run();
        t();
    }

    public final void t() {
    }

    public static void main(String[] args) {
        A a = new A();
        a.s();
        a = new B();
        a.s();
        B b =new B();
        b.s();
        a=b;
        a.s();
        b.s();
    }


    static class A{
        public static void s() {
            System.out.println("-----A");
        }
    }

    static class B extends A{
        public static void s() {
            System.out.println("-----B");
        }
    }
}
