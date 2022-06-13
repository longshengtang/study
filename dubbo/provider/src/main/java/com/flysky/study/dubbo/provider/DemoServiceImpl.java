package com.flysky.study.dubbo.provider;

import com.flysky.study.dubbo.api.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
