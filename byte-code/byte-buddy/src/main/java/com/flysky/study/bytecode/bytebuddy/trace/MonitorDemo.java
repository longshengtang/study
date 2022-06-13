
package com.flysky.study.bytecode.bytebuddy.trace;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

public class MonitorDemo {

    @RuntimeType
    public static Object intercept(@SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return callable.call();
        } finally {
            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
        }
    }

}
