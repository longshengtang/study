package com.flysky.study.spike.jdk.reflect;

import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.Method;

public class ReflectTest {
    @Test
    public void getBeanInfo() throws IntrospectionException, NoSuchMethodException {
//        BeanInfo a = Introspector.getBeanInfo(A.class);
//        BeanInfo b = Introspector.getBeanInfo(B.class);
//
//        System.out.println(a);
//        System.out.println(b);
//        ReflectionUtils.
        //        String name = userMapperClass.getName();
        printMethod(UserMapper.class);
        System.out.println("--------");
        printMethod(UserMapperImpl.class);
        Method getById = UserMapper.class.getMethod("getById", int.class);
        Method getById2 = UserMapperImpl.class.getMethod("getById", int.class);
        System.out.println("getById.equals(getById2) = " + getById.equals(getById2));
    }

    private static void printMethod(Class<?> userMapperClass) {
        for (Method method : userMapperClass.getMethods()) {
            System.out.println("method = " + method);
//            System.out.println("method.getName() = " + method.getName());
//            System.out.println("name+\".\"+method.getName() = " + name + "." + method.getName());
        }
//        System.out.println("UserMapper.class.getName() = " + name);
    }

    interface UserMapper{
        Object getById(int userId);
    }
    class UserMapperImpl implements UserMapper {
        public Object getById(int userId){
            return null;
        }
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
