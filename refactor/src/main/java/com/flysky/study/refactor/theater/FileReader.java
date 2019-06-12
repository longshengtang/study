package com.flysky.study.refactor.theater;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public static String parse(String file) {
        StringBuilder sb = new StringBuilder();
        try {
            Stream<String> lines = Files.lines(Paths.get(file));
            lines.forEach(line -> {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
