package com.flysky.study.bytecode.bytebuddy.agent;

import com.flysky.study.bytecode.bytebuddy.trace.BizMethod;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.Callable;

public class BootstrapAgent {

    public static void main(String[] args) throws Exception {
        premain(null, ByteBuddyAgent.install());
        BizMethod bm = new BizMethod();
        long start = System.currentTimeMillis();
        String s = bm.queryUserInfo("123", "455");
        System.out.println(s);
//        HttpURLConnection urlConnection = (HttpURLConnection) new URL("http://www.google.com").openConnection();
//        System.out.println(urlConnection.getRequestMethod());
    }

    public static void premain(String arg, Instrumentation inst) throws Exception {
//        File temp = Files.createTempDirectory("tmp").toFile();
//        ClassInjector.UsingInstrumentation.of(temp, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, inst).inject(Collections.singletonMap(
//                new TypeDescription.ForLoadedType(MyInterceptor.class),
//                ClassFileLocator.ForClassLoader.read(MyInterceptor.class)//.resolve()
//        ));
        new AgentBuilder.Default()
                .ignore(ElementMatchers.nameStartsWith("net.bytebuddy."))
//                .ignore(ElementMatchers.none())
//                .with(AgentBuilder.RedefinitionStrategy.DISABLED)
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .with(AgentBuilder.Listener.StreamWriting.toSystemOut())
//                .enableBootstrapInjection(temp, inst)
//                .type(ElementMatchers.nameEndsWith(".HttpURLConnection"))
                .type(ElementMatchers.nameEndsWith(".BizMethod"))
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
//                        return null;
                        return builder.method(ElementMatchers.named("queryUserInfo")).intercept(MethodDelegation.to(MyInterceptor.class));
//                        return builder.method(ElementMatchers.named("getRequestMethod")).intercept(MethodDelegation.to(MyInterceptor.class));
                    }

//                    @Override
//                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader) {
//                        return builder.method(ElementMatchers.named("getRequestMethod")).intercept(MethodDelegation.to(MyInterceptor.class));
//                    }
                }).installOn(inst);
    }

    public static class MyInterceptor {

        public static String intercept(@SuperCall Callable<String> zuper) throws Exception {
            System.out.println("Intercepted!");
            return zuper.call();
        }
    }
}
