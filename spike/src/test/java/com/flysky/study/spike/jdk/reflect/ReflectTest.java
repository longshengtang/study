package com.flysky.study.spike.jdk.reflect;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

public class ReflectTest {
    @Test
    public void getBeanInfo() throws IntrospectionException {
        BeanInfo a = Introspector.getBeanInfo(A.class);
        BeanInfo b = Introspector.getBeanInfo(B.class);

        System.out.println(a);
        System.out.println(b);

    }


    class A{
        private Integer a;
        private String b;
        private String c;
        private String d ;

        public A(String d) {
            this.d = d;
        }

        private void setC(String c){
            this.c=c;
        }

        public String getC() {
            return c;
        }

        public Integer getA() {
            return a;
        }
        public Integer retA() {
            return a;
        }


        public void setA(Integer a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
    class B{
        private Integer aa;
        private String bb;
    }
}
