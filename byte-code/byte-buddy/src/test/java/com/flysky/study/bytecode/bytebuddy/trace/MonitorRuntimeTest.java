package com.flysky.study.bytecode.bytebuddy.trace;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MonitorRuntimeTest {
    @Test
    public void test_byteBuddy() throws Exception {
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                .subclass(BizMethod.class)
                .method(ElementMatchers.named("queryUserInfo"))
                .intercept(MethodDelegation.to(MonitorDemo.class))
                .make();

        // 加载类
        Class<?> clazz = dynamicType.load(this.getClass().getClassLoader())
                .getLoaded();

        // 反射调用
        clazz.getMethod("queryUserInfo", String.class, String.class).invoke(clazz.newInstance(), "10001", "Adhl9dkl");
    }

    @Ignore
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //java.lang.IllegalArgumentException: None of [public static java.lang.Object com.flysky.study.bytecode.bytebuddy.trace.MonitorRuntime.intercept(java.lang.reflect.Method,java.lang.Object[],java.lang.Object,java.util.concurrent.Callable) throws java.lang.Exception] allows for delegation from public static void java.lang.System.load(java.lang.String)
        TypePool.Resolution describe = TypePool.Default.ofBootLoader().describe("java.lang.System");
        Class<?> load0 = new ByteBuddy()
                .redefine(describe.resolve(), ClassFileLocator.ForClassLoader.ofBootLoader())
                .method(named("load"))
                .intercept(MethodDelegation.to(MonitorRuntime.class))
                .make().load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION).getLoaded();

    }
}
