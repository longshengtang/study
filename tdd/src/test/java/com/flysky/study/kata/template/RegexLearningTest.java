package com.flysky.study.kata.template;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearningTest {
    //    @Test
//    public void testHowGroupCountWorks() {
//        String haystack = "The needle shop sells needles";
//        String regex = "(needle)";
//        Matcher matcher = Pattern.compile(regex).matcher(haystack);
//        assertThat(matcher.groupCount()).isEqualTo(2);
//    }
    @Test
    public void testFindStartAndEnd() {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertThat(matcher.find()).isEqualTo(true);
        assertThat(matcher.start()).isEqualTo(4);
        assertThat(matcher.end()).isEqualTo(10);


        assertThat(matcher.find()).isEqualTo(true);
        assertThat(matcher.start()).isEqualTo(22);
        assertThat(matcher.end()).isEqualTo(28);
    }

    @Test
    public void testFind$() {
        String template = "${one},${two},${three}";
        Matcher matcher = Pattern.compile("\\$\\{[^}]*\\}").matcher(template);
        assertThat(matcher.matches()).isFalse();
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    @Test
    public void testFind$2() {
        String template = "${5}";
        Matcher matcher = Pattern.compile("\\$\\{[^}]+\\}").matcher(template);
        assertThat(matcher.matches()).isTrue();
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    @Test
    public void testCaret() {
        Matcher matcher = Pattern.compile("[\\^]").matcher("^");
        assertThat(matcher.matches()).isTrue();
    }
    @Test
    public void whiteLine() {
        Matcher matcher = Pattern.compile("^[\\s&&[^\\n]]*\\n$").matcher(" \n");
        assertThat(matcher.matches()).isTrue();
    }
}
