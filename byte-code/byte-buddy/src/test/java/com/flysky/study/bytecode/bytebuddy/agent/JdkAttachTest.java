package com.flysky.study.bytecode.bytebuddy.agent;

import net.bytebuddy.agent.ByteBuddyAgent;
import org.junit.Test;

public class JdkAttachTest {

    @Test
    public void testLoadAgent() throws Exception {
        attach_and_detach();
        String classpath = System.getProperty("java.library.path");
        String javaclasspath = System.getProperty("java.class.path");
        System.out.println("javaclasspath = " + javaclasspath);
        System.out.println("classpath = " + classpath);
//        System.out.println("System.getProperties() = " + System.getProperties());
        byteBuddyAgentInstall();
    }

    private void byteBuddyAgentInstall() {
        ByteBuddyAgent.install();
    }

    private void attach_and_detach() throws Exception {
        new JdkAttach().loadAgent();
    }
}
