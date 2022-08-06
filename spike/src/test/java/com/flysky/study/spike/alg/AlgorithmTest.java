package com.flysky.study.spike.alg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmTest {

    private int[] src = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private int[] order_dest = {};

    @Test
    public void construct_tree() {
        int[] act = {};
        assertThat(act).isEqualTo(order_dest);

//        A a =new A();

        System.out.println(new Date().getTime());
    }

    @Test
    public void null_return_empty() {
        assertThat(findContainsAllTargetChars("ADOBECODEBANC", "")).isEqualTo("");
        assertThat(findContainsAllTargetChars("ADOBECODEBANC", null)).isEqualTo("");
        assertThat(findContainsAllTargetChars("", null)).isEqualTo("");
        assertThat(findContainsAllTargetChars(null, "null")).isEqualTo("");
    }

    @Test
    public void actual_equals_result() {
        assertThat(findContainsAllTargetChars("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
        assertThat(findContainsAllTargetChars("a", "a")).isEqualTo("a");
        assertThat(findContainsAllTargetChars("a", "aa")).isEqualTo("");
    }

    private String findContainsAllTargetChars(String src, String target) {

        String result = "";

        if (Objects.isNull(src) || Objects.isNull(target)
                || src.length() < target.length()
        ) {
            return result;
        }
        List<Character> list = new ArrayList<>(target.length());
        for (int i = 0; i < target.length(); i++) {
            list.add(target.charAt(i));
        }

        for (int i = 0; i < src.length(); i++) {
            if (!list.contains(src.charAt(i))) {
                continue;
            }
            String tmp = find(src, i, new ArrayList<>(list));
            if (tmp.length() > 0) {
                if (result.length() == 0 || tmp.length() < result.length()) {
                    result = tmp;
                }
            }
            if (src.length() - (i + 1) < target.length()) {
                break;
            }
        }

        return result;
    }

    private String find(String src, int start, List<Character> list) {
        int end = 0;
        for (int i = start; i < src.length(); i++) {
            list.remove((Character) src.charAt(i));
            if (list.isEmpty()) {
                end = i + 1;
                break;
            }
        }

        return end == 0 ? "" : src.substring(start, end);
    }

    class A {
        B b = new B();
    }

    class B {
        A a = new A();
    }


}
