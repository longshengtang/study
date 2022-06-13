package com.flysky.study.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringwebApplication {
    public static void main(String[] args) {
        System.out.println("start---");
        System.load("/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/lib/libattach.dylib");
        System.out.println("end---");
        SpringApplication.run(SpringwebApplication.class);
    }
}
