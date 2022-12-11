package com.flysky.study.bytecode.bytebuddy.trace;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class MonitorRuntime {
    @RuntimeType
    public static Object intercept(@Origin Method method
            , @AllArguments Object[] args
//            , @Argument(0) Object arg0
            , @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        Object resObj = null;
        try {
            resObj = callable.call();
            return resObj;
        } finally {
            System.out.println("-----------------------------------");
//            System.out.println("执行方法：" + method);
//            System.out.println("入参个数：" + method.getParameterCount());
//            for (int i = 0; i < method.getParameterCount(); i++) {
//                System.out.println("入参类型：" + method.getParameterTypes()[i].getTypeName() );
//                System.out.println("参数内容：" + args[i]);
//            }
//            System.out.println("出参类型：" + method.getReturnType().getName());
//            System.out.println("出参结果：" + resObj);
            StringBuilder sb = new StringBuilder();
            sb.append("方法").append(method.getName()).append("(");
            for (int i = 0; i < method.getParameterCount(); i++) {
//                System.out.println("入参类型：" + method.getParameterTypes()[i].getTypeName() );
//                System.out.println("参数内容：" + args[i]);
                sb.append(i > 0 ? "," : "").append(args[i]);
            }
            sb.append(")=====>耗时：").append(System.currentTimeMillis() - start).append("毫秒");
            System.out.println(sb);
//            System.out.println("-----------------------------------\n");
        }
    }
}
