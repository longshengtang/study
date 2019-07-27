package com.flysky.study.regex;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    private RegexUtil r;

    @Before
    public void setUp() {
        r = new RegexUtil();
    }

    @Test
    public void emptyReturnEmpty() {
        assertT(r.duplicatedWords(""), Collections.emptyList());
    }

    @Test
    public void noDuplicatedWordReturnEmpty() {
        assertT(r.duplicatedWords("There is no duplicated word"), Collections.emptyList());
    }

    @Test
    public void hasOneDuplicatedWord() {
        assertT(r.duplicatedWords("It has a duplicated word word\nis is no"), "word word", "is is");
    }

    @Test
    public void hasDuplicatedWordInTwoLines() {
        assertT(r.duplicatedWords("It has a duplicated word\nis\nis no"), "word word", "is is");
    }

    private void assertT(List<? extends Object> actual, Object... expected) {
        assertThat(actual.size()).isEqualTo(expected.length);
        assertThat(actual).isEqualTo(Arrays.asList(expected));
    }

    private void assertT(List<? extends Object> actual, List<? extends Object> expected) {
        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void matcherTimeFormat24HourHex() {
        Pattern compile = Pattern.compile("(1[0-9]|2[0-3]|[1-9]):[0-9][0-9]");
        assertThat(compile.matcher("1:10").matches()).isTrue();
        assertThat(compile.matcher("23:59").matches()).isTrue();
        assertThat(compile.matcher("19:30").matches()).isTrue();
    }

    @Test
    public void backslashB() {
        Pattern compile = Pattern.compile("\\b[a-zA-Z]+\\b");
        assertThat(compile.matcher("abc").matches()).isTrue();
    }

    @Test
    public void caseInsensitive() {
        Pattern compile = Pattern.compile("abc", Pattern.CASE_INSENSITIVE);
        assertThat(compile.matcher("abc").matches()).isTrue();
        assertThat(compile.matcher("Abc").matches()).isTrue();
        assertThat(compile.matcher("aBc").matches()).isTrue();
        assertThat(compile.matcher("abC").matches()).isTrue();
        assertThat(compile.matcher("ABc").matches()).isTrue();
        assertThat(compile.matcher("AbC").matches()).isTrue();
        assertThat(compile.matcher("aBC").matches()).isTrue();
        assertThat(compile.matcher("ABC").matches()).isTrue();
    }

    @Test
    public void keepTwoDecimals() {
        //匹配整个数字，但是又可以取其中某个部分的内容，然后使用部分替换整体数字
        Pattern compile = Pattern.compile("(\\.\\d\\d[1-9]?)\\d*");
        Matcher matcher = compile.matcher(".357");
        matcher.find();
        String actual = matcher.replaceAll(matcher.group(1));
        assertThat(actual).isEqualTo(".357");


        Matcher m = compile.matcher(".350");
        assertThat(m.find()).isTrue();
        actual = m.replaceAll(m.group(1));
        assertThat(actual).isEqualTo(".35");
    }

    @Test
    public void separateNumberByComma() {
        Matcher matcher = Pattern.compile("(?<=\\d)(?=(\\d\\d\\d)+$)").matcher("I have money $123456789");

        assertThat(matcher.find()).isTrue();
        assertThat(matcher.replaceAll(",")).isEqualTo("I have money $123,456,789");
    }
}
