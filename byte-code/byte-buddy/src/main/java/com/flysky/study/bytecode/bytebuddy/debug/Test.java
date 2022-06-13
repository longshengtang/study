package com.flysky.study.bytecode.bytebuddy.debug;

import net.bytebuddy.agent.ByteBuddyAgent;

import java.lang.instrument.Instrumentation;

public class Test {
    public static void main(String[] args) {
        Instrumentation install = ByteBuddyAgent.install();
        System.out.println(install);
    }
}
