package com.flysky.study.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public List<String> duplicatedWords(String lines) {

        List<String> result = new ArrayList<>();
        String s = "\033[7m$1\033[m$2\033[7m$3\033[m";
        Pattern r1 = Pattern.compile("\\b([a-z]+)((?:\\s|\\<[^>]+\\>)+)(\\1\\b)", Pattern.CASE_INSENSITIVE);
        Pattern r2 = Pattern.compile("^(?:[^\\e]*\\n)+", Pattern.MULTILINE);
        Pattern r3 = Pattern.compile("^([^\\n]+)", Pattern.MULTILINE);
        String text = lines;
        text = r1.matcher(text).replaceAll(s);
        text = r2.matcher(text).replaceAll("");
        text = r3.matcher(text).replaceAll("test: $1");
        System.out.println(text);

        Matcher matcher = r1.matcher(lines);
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }

    public String convertHttpUrl(String httpUrl) {
        Matcher matcher = Pattern.compile("\\b(http://[-a-z0-9]+(\\.[-a-z0-9]+)*\\.(com|edu|info)\\b(/[-a-z0-9_:\\@&?=+,.!/~*'%\\$]*(?<![.,!?]))?)").matcher(httpUrl);
//        Matcher matcher = Pattern.compile("\\b(http://[-a-z0-9]+(\\.[-a-z0-9]+)*\\.(com|edu|info)\\b(/[-a-z0-9,.!]*(?<![.,!]))?)").matcher(httpUrl);
        if (matcher.find()) {
            System.out.println("----------");
            return matcher.group();
        }
        return null;
    }

    public String multiParagraph(String src) {
        Matcher matcher = Pattern.compile("^[ \t]*$",Pattern.MULTILINE).matcher(src);
        return matcher.replaceAll("<p>");
    }
}