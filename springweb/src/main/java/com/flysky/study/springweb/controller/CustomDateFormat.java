package com.flysky.study.springweb.controller;

import com.flysky.study.comm.util.CommStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.flysky.study.comm.util.DateUtil.parseDate;
import static com.flysky.study.comm.util.DateUtil.parseDateTime;

public class CustomDateFormat extends DateFormat {
    private static final Logger logger = LoggerFactory.getLogger(CustomDateFormat.class);
    private DateFormat defaultDateFormat;
    private DateTimeFormatter fmtYmdHms = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

    public CustomDateFormat(DateFormat defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSSZ").format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        return defaultDateFormat.parse(source, pos);
    }

    @Override
    public Date parse(String source) throws ParseException {
        try {
            if (source.contains(":")) {
                return parseDateTime(source, fmtYmdHms);
            }
            return parseDate(source);
        } catch (Throwable e) {
            logger.warn("转换异常：{}异常信息{}", source, CommStringUtil.getStackTrace(e));
            return defaultDateFormat.parse(source);
        }
    }

    @Override
    public Object clone() {
        Object format = defaultDateFormat.clone();
        return new CustomDateFormat((DateFormat) format);
    }
}