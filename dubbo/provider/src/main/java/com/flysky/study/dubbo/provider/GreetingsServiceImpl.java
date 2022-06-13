package com.flysky.study.dubbo.provider;

import com.flysky.study.dubbo.api.GreetingsService;

public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
