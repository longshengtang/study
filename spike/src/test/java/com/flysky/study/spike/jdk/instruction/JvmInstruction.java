package com.flysky.study.spike.jdk.instruction;

public class JvmInstruction implements MyInterface {
    public static void main(String[] args) {
        testInstruction();
    }

    public static void testInstruction() {
        JvmInstruction jvmInstruction = new JvmInstruction();
        ((MyInterface)jvmInstruction).interfaceMethod();
        jvmInstruction.interfaceMethod();
        jvmInstruction.privateMethod();
        jvmInstruction.publicMethod();
        jvmInstruction.protectedMethod();
        jvmInstruction.finalMethod();
        jvmInstruction.staticMethod();
        JvmInstruction.staticMethod();
        staticMethod();
    }

    private void privateMethod() {

    }

    public void publicMethod() {

    }

    void protectedMethod() {

    }

    public final void finalMethod() {

    }

    public static void staticMethod() {

    }

    @Override
    public void interfaceMethod() {
    }

}

interface MyInterface{
    void interfaceMethod();
}
