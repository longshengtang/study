package com.flysky.study.dubbo.consumer;

import com.flysky.study.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/dubbo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
        System.in.read();
    }
}
