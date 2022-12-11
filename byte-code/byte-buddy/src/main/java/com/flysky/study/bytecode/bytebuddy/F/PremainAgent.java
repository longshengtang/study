package com.flysky.study.bytecode.bytebuddy.F;

import com.flysky.study.bytecode.bytebuddy.trace.MonitorRuntime;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;

public class PremainAgent {

    public static void premain(String agentParam, Instrumentation inst) {
        //com.flysky.MyClass#m1,m2,m3
        System.out.println("premain参数：" + agentParam);
        if (agentParam == null || agentParam.length() < 1) {
            return;
        }
        String[] clazzMethods = agentParam.split("#");
        String clazz = clazzMethods[0];
        if (clazz == null || clazz.length() < 1) {
            return;
        }
        String methodNameRegex = "[_a-zA-Z0-9]+";
        if (clazzMethods.length > 1) {
            methodNameRegex = clazzMethods[1];
        }

        // method指定哪些方法需要被拦截，ElementMathers.any指定了所有的方法，声明intercept拦截器
        ElementMatcher.Junction<NamedElement> namedElement = ElementMatchers.nameMatches(methodNameRegex);
        AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader, javaModule) -> builder.method(namedElement)
                .intercept(MethodDelegation.to(MonitorRuntime.class));
        /**
         * 1.type指定了agent拦截的包名，以[com.agent]作为前缀
         * 2.指定了转换器transformer
         * 3.将配置安装到Instrumentation
         */
        new AgentBuilder.Default()
                .type(ElementMatchers.named(clazz))
                .transform(transformer)
                .installOn(inst);
    }

    public static void premain(String agentParam) {
        System.out.println("单个参数的premain方法执行：" + agentParam);
    }
}
