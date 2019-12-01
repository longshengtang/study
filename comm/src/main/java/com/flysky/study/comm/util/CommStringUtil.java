package com.flysky.study.comm.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class CommStringUtil {
    public static String getStackTrace(Throwable e) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        e.printStackTrace(printWriter);
        return result.toString();
    }
}

