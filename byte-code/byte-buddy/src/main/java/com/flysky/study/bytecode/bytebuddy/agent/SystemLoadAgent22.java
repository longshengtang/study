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

public class SystemLoadAgent22 {
    public static void main(String[] args) throws Exception {
        premain(null, ByteBuddyAgent.install());
        String attach = "/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/lib/libattach.dylib";
//        System.loadLibrary(attach);
        System.load(attach);
    }
    public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, IOException {

        File temp = Files.createTempDirectory("tmp").toFile();
        ClassInjector.UsingInstrumentation.of(temp, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, inst)
                .inject(Collections.singletonMap(
                new TypeDescription.ForLoadedType(SystemLoadAdvice.class),
                ClassFileLocator.ForClassLoader.read(SystemLoadAdvice.class)
        ));

        Class<?> target = Class.forName("java.lang.System");
        ClassLoader classLoader = target.getClassLoader();
        new ByteBuddy()
                .redefine(target, ClassFileLocator.ForClassLoader.ofBootLoader())
                .visit(Advice.to(SystemLoadAdvice.class).on(ElementMatchers.named("load")))
                .make()
                .load(classLoader, ClassReloadingStrategy.of(inst));
    }
}
