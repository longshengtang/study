package com.flysky.study.comm.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.ZoneId.systemDefault;
import static java.time.format.DateTimeFormatter.ofPattern;

public class DateUtil {

    public static String formatCurrentDate(String format) {
        return formatDate(new Date(), format);
    }

    public static String formatDate(Date date, String format) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), systemDefault());
        return localDateTime.format(ofPattern(format));
    }

    public static Date parseDate(String source) {
        return parseDate(source, fmtYmd);
    }

    public static Date parseDate(String source, String fmt) {
        return parseDate(source, DateTimeFormatter.ofPattern(fmt));
    }

    private static Date parseDate(String source, DateTimeFormatter fmtDate) {
        Instant instant = LocalDate.parse(source, fmtDate).atStartOfDay(systemDefault()).toInstant();
        return Date.from(instant);
    }


    public static Date parseDateTime(String source) {
        return parseDateTime(source, fmtYmdHms);
    }

    public static Date parseDateTime(String source, String fmt) {
        return parseDateTime(source, DateTimeFormatter.ofPattern(fmt));
    }

    public static Date parseDateTime(String source, DateTimeFormatter fmt) {
        Instant instant = LocalDateTime.parse(source, fmt).atZone(systemDefault()).toInstant();
        return Date.from(instant);
    }


    public static void main(String[] args) {
        System.out.println(parseDateTime("2019-11-11 11:11:11", fmtYmdHms));
    }

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public static final DateTimeFormatter fmtYmdHms = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
    public static final DateTimeFormatter fmtYmd = DateTimeFormatter.ofPattern(DATE_PATTERN);

}
