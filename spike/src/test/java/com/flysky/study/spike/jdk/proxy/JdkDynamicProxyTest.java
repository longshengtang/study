package com.flysky.study.spike.jdk.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class JdkDynamicProxyTest {


    @Test
    public void test_invoke() throws InterruptedException {
        Target t = new TargetImpl();
        System.out.println("t.myInvoke(3,4) = " + t.myInvoke(3, 4));

        Object o = Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{Target.class}, new MyInvokeHandler(t));
        Object o2 = Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{Target.class}, new MyInvokeHandler(t));
        System.out.println("o.getClass() = " + o.getClass());
        System.out.println("o2.getClass() = " + o2.getClass());
        Target target = (Target) o;
        Object result = target.myInvoke(4, 5);
        System.out.println("result = " + result);
        System.out.println("target = " + target);
        System.out.println("o2 = " + o2);
        Target obj= (Target) o2;
        System.out.println("obj = " + obj.myInvoke(5,6));

        while (true){
            TimeUnit.SECONDS.sleep(3);
        }


    }

    @Test
    public void generateSameClass() {

        Object o = Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{Target.class}, new MyInvokeHandler(null));
        Object o2 = Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{Target.class}, new MyInvokeHandler(null));
        assertThat(o.getClass().getName()).startsWith("com.sun.proxy.$Proxy");
        assertThat(o.getClass()).isEqualTo(o2.getClass());
    }

    public interface Target {
        Object myInvoke(int a, int b);
        Object a1(int a, int b);
        Object a2(int a, int b);
        Object a3(int a, int b);
        Object a4(int a, int b);
        Object a5(int a, int b);
        Object a6(int a, int b);
        Object a7(int a, int b);
        Object a8(int a, int b);
        Object a9(int a, int b);
        Object a10(int a, int b);
        Object a11(int a, int b);
        Object a12(int a, int b);
        Object a13(int a, int b);
        Object a14(int a, int b);
        Object a15(int a, int b);
    }

    public class TargetImpl implements Target {
        public Object myInvoke(int a, int b) {
            System.out.println("-------开始调用实际方法--------");
            return a + b;
        }

        @Override
        public Object a1(int a, int b) {
            return null;
        }

        @Override
        public Object a2(int a, int b) {
            return null;
        }

        @Override
        public Object a3(int a, int b) {
            return null;
        }

        @Override
        public Object a4(int a, int b) {
            return null;
        }

        @Override
        public Object a5(int a, int b) {
            return null;
        }

        @Override
        public Object a6(int a, int b) {
            return null;
        }

        @Override
        public Object a7(int a, int b) {
            return null;
        }

        @Override
        public Object a8(int a, int b) {
            return null;
        }

        @Override
        public Object a9(int a, int b) {
            return null;
        }

        @Override
        public Object a10(int a, int b) {
            return null;
        }

        @Override
        public Object a11(int a, int b) {
            return null;
        }

        @Override
        public Object a12(int a, int b) {
            return null;
        }

        @Override
        public Object a13(int a, int b) {
            return null;
        }

        @Override
        public Object a14(int a, int b) {
            return null;
        }

        @Override
        public Object a15(int a, int b) {
            return null;
        }
    }

    public class MyInvokeHandler implements InvocationHandler {
        Target target;

        public MyInvokeHandler(Target t) {
            this.target = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("method.getName() = " + method.getName() /*+ ",proxy=" + proxy*/);
            if (args != null) {
                System.out.println("Arrays.asList(args) = " + Arrays.asList(args));
            }
            System.out.println("proxy = " + proxy.getClass());
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            }

            System.out.println("在调用" + method + "之前输出");
            Object invokeResult = method.invoke(target, args);
            System.out.println("在调用" + method + "之后输出");


            return invokeResult;
        }
    }
}
