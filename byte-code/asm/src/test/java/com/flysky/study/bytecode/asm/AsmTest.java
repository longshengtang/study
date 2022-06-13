package com.flysky.study.bytecode.asm;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;

import static org.objectweb.asm.Opcodes.*;

public class AsmTest {

    private final TraceClassVisitor tcw = getTraceClassVisitor();

    @Test
    public void testLoadDylib() {
        A a = new A();
    }

    @Test
    public void testMyPrintClass() throws IOException {
        ClassPrinter printWriter = new ClassPrinter();
        String className = "com.flysky.study.bytecode.asm.B";
        className="x";
        ClassReader cr = new ClassReader(className);
        cr.accept(printWriter, 0);
//        cr.accept(,0);
    }
    @Test
    public void testTraceClassVisitor() throws IOException {
//        printClassForClassReader(new ClassReader("com.flysky.study.bytecode.asm.B"));
        String className = "com.flysky.study.bytecode.asm.A";
        className="x";
        printClassForClassReader(new ClassReader(className));

    }

    private void printClassForClassReader(ClassReader cr) {
        cr.accept(tcw,0);
    }

    private TraceClassVisitor getTraceClassVisitor() {
        TraceClassVisitor tcw = new TraceClassVisitor(null, new Textifier(),new PrintWriter(System.out));
        return tcw;
    }

    @Test
    public void testGenerate() {//2.2.3
        ClassWriter cw2 = new ClassWriter(0);
        TraceClassVisitor cw = new TraceClassVisitor(cw2, new Textifier(),new PrintWriter(System.out));
        cw.visit(V1_5, ACC_PUBLIC/* + ACC_ABSTRACT + ACC_INTERFACE*/,
                "pkg/Comparable", null, "java/lang/Object",
                new String[]{"pkg/Mesurable"});
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();

//        printClassForClassReader(new ClassReader(cw.toByteArray()));
    }

    @Test
    public void testTraceGenerate() {
        ClassWriter cw = new ClassWriter(0);
        PrintWriter printWriter = new PrintWriter(System.out);
        Textifier t = new Textifier();
        TraceClassVisitor tcw = new TraceClassVisitor(cw, t,printWriter);
        tcw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object",
                new String[]{"pkg/Mesurable"});
        tcw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        tcw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        tcw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        tcw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        tcw.visitEnd();
    }
}
