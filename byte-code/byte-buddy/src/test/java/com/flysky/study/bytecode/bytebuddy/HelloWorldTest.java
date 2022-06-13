package com.flysky.study.bytecode.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import sun.misc.Launcher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloWorldTest {
    HelloWorld helloWorld = new HelloWorld();

    @Test
    public void testHello() throws Exception {
        String result = helloWorld.hello();
        Assert.assertEquals("hello world", result);
    }

    @Ignore
    @Test
    public void testSaveIn() throws IOException {
        File f = new File("/Users/longlong/flysky/study/bytecode");
        new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make().saveIn(f);
    }

    @Test
    public void testGenerateMethodToString() throws IllegalAccessException, InstantiationException {
        ByteBuddy byteBuddy = new ByteBuddy();
        Class<?> dynamicType = byteBuddy
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded();

        assertThat(dynamicType.newInstance().toString(), is("Hello World!"));
        ByteBuddyAgent.install();
        ByteBuddyAgent.install();
    }

    @Test
    public void loaderLibAttachSoTwice() {
//        System.out.println("new LoadLibSoA() = " + new LoadLibSoA());
        System.out.println("LoadLibSoA.class.getClassLoader() = " + LoadLibSoA.class.getClassLoader());
        System.out.println("LoadLibSoB.class.getClassLoader() = " + LoadLibSoB.class.getClassLoader());
//        System.out.println("new LoadLibSoB() = " + new LoadLibSoB());
    }

    @Test
    public  void testLoader() {
        // 可以获取是哪个类加载器加载  Launcher 这个类
        ClassLoader classLoader = Launcher.class.getClassLoader();
        System.out.println("classLoader : " + classLoader);
        System.out.println("-------------------"+this.getClass().getClassLoader());
        String bootClassPath = System.getProperty("sun.boot.class.path");
        String[] split = bootClassPath.split(":");

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    @Ignore
    @Test
    public void t2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader mc = new MyClassLoader();
        Class cls = mc.findClass("com.flysky.study.bytecode.bytebuddy.LoadLibSoA");
        Object o = cls.newInstance();


        try {
            ///Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre
            System.out.println("System.getProperty(\"java.home\") = " + System.getProperty("java.home"));
            ByteBuddyAgent.install();
        } catch (Throwable e) {
            System.out.println("e.getCause() = " + e.getCause());
            e.printStackTrace();
            String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
            System.out.println("rootCauseMessage = " + rootCauseMessage);
//            System.out.println("e instanceof UnsatisfiedLinkError = " + (e instanceof UnsatisfiedLinkError));
        }
        //由于o是由mc加载的。而Person是由App加载的，所有不可以转换＝来自于两个不同的加载器
        //Person p = (Person) o;//类型转换错误ClassCastException
        //System.err.println(p);
    }

    @Ignore
    @Test
    public void testLoadToolJarClassUseSystemClassLoader() throws ClassNotFoundException, MalformedURLException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> clszz = systemClassLoader.loadClass("com.sun.tools.attach.VirtualMachine");
        System.out.println("systemClassLoader = " + systemClassLoader);
        System.out.println("clszz = " + clszz);
        System.out.println("clszz.getClassLoader() = " + clszz.getClassLoader());

        URL url = new File("").toURI().toURL();
        URLClassLoader uc = new URLClassLoader(new URL[]{url});
        System.out.println("uc = " + uc);

    }
    @Ignore
    @Test
    public void testLoadToolJarClassUseUrlClassLoader() throws ClassNotFoundException, MalformedURLException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);

//        URL url = new File(System.getProperty("java.home"),"../lib/tools.jar").toURI().toURL();
//        URLClassLoader uc = new URLClassLoader(new URL[]{url},null);//使用自定义URL类加载器加载
        URLClassLoader uc = new URLClassLoader(new URL[]{new File("").toURL()});//使用系统类加载器加载
        System.out.println("uc = " + uc);
        System.out.println("uc.getParent() = " + uc.getParent());
        Class<?> vclazz = uc.loadClass("com.sun.tools.attach.VirtualMachine");
        System.out.println("vclazz.getClassLoader() = " + vclazz.getClassLoader());

    }

    @Test
    public void testRemoveSo() throws NoSuchFieldException, IllegalAccessException {
        printLibnames(false);
    }
    public void printLibnames(boolean remove) {
        System.out.println("start-------------------------------");
        try {
            Field loadedLibraryNames = ClassLoader.class.getDeclaredField("loadedLibraryNames");
            loadedLibraryNames.setAccessible(true);
            System.out.println("loadedLibraryNames = " + loadedLibraryNames);
            Collection<String> o = (Collection<String>) loadedLibraryNames.get(null);
            Iterator<String> iter = o.iterator();
            while (iter.hasNext()) {
                String next = iter.next();
                System.out.println("iter.next() = " + next);
                if (next.contains("attach") && remove) {
                    iter.remove();
                    System.out.println("remove the lib name  = " + next);
                }

            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("end-------------------------------");
    }

}
