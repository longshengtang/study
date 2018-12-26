package com.flysky.study.service.impl;

import com.flysky.study.service.ActionService;
import com.flysky.study.service.MessageService;
import com.flysky.study.service.MyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    public MessageServiceImpl() {
        System.out.println("---------------");
    }

    @Autowired
    private ActionService actionService;

    @Override
    public String say(String name) {
        return actionService.doSay(name);
    }

}