package com.flysky.study.bytecode.bytebuddy.agent;

import net.bytebuddy.asm.Advice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class SystemLoadAdvice {
    @Advice.OnMethodEnter(inline = false)
    public static void enter(@Advice.AllArguments Object[] args) {

        System.out.println("enter！");

        System.out.println("- @AllArguments !!");
        for (Object o : args) {
            String s = o.toString();
            System.out.println("- - - type : " + o.getClass().getName() + ", value : " + s);
//            if (s.contains("attach"))
            System.err.println(getStackTrace(new Exception("trace:" + s)));
        }
    }

    public static String getStackTrace(Throwable e) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        e.printStackTrace(printWriter);
        return result.toString();
    }
}
