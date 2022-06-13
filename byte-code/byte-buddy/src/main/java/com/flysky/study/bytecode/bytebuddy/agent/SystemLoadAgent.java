package com.flysky.study.bytecode.bytebuddy.agent;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.nio.file.Files;
import java.util.Collections;

public class SystemLoadAgent {
    public static void main(String[] args) throws Exception {
        premain(null, ByteBuddyAgent.install());
        String attach = "/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/lib/libattach.dylib";
//        System.loadLibrary(attach);
        System.load(attach);
    }
    public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, IOException {

        //此处表明，在启动类加载器加载的类上面做切面，必须将切面类添加到启动类加载器的boot classpath当中
        File temp = Files.createTempDirectory("tmp").toFile();
        //此处将inst添加到boot classpath中，
        ClassInjector.UsingInstrumentation.of(temp, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, inst)
                //此处将SystemLoadAdvice注入到BOOTSTRAP类加载器中
                .inject(Collections.singletonMap(
                new TypeDescription.ForLoadedType(SystemLoadAdvice.class),//此处表明SystemLoadAdvice最终会被两个类加载器加载，一个为系统类加载器，一个为启动类加载器
                ClassFileLocator.ForClassLoader.read(SystemLoadAdvice.class)
        ));//结果使得引导类加载器可以找到SystemLoadAdvice类

        Class<?> target = Class.forName("java.lang.System");//保证System类被引导类加载器加载
        ClassLoader classLoader = target.getClassLoader();
        new ByteBuddy()
                .redefine(target, ClassFileLocator.ForClassLoader.ofBootLoader())
                .visit(Advice.to(SystemLoadAdvice.class).on(ElementMatchers.named("load")))
//                .visit(Advice.to(SystemLoadAdvice.class).on(ElementMatchers.named("loadLibrary")))
                .make()
                .load(classLoader, ClassReloadingStrategy.of(inst));
//                .load(ClassLoader.getSystemClassLoader(), ClassReloadingStrategy.of(inst));
    }
}
