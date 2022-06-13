package com.flysky.study.bytecode.bytebuddy;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class MyClassLoader extends ClassLoader {
    /**
     * name:cn.itcast.demo.Person
     * 根据包名找到.class文件
     * cn.itcast.demo.person = > cn/itcast/demo/Person.class
     */
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String classNameWithPackage = name;
        Class<?> cls = null;
        try {
            //先将
            name = name.replace(".", "/");
            name += ".class";
            //确定目录
            URL url = MyClassLoader.class.getClassLoader().getResource(name);
            System.err.println(">>:" + url.getPath());
            File file = new File(url.getPath());
            InputStream in = new FileInputStream(file);
            //读取这个.class文件的字节码
            byte[] b = new byte[in.available()];//直接声明这个字节大小为这个文件的大小
            int len = in.read(b);//len=621
            System.err.println(len);
            /**
             * 第一个参数是类名
             */
            cls = defineClass(classNameWithPackage, b, 0, len);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cls;
    }
}
