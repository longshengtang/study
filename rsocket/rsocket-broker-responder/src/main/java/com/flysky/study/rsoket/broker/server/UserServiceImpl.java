package com.flysky.study.rsoket.broker.server;

import com.alibaba.spring.boot.rsocket.RSocketService;
import com.flysky.study.rsocket.brocker.api.model.User;
import com.flysky.study.rsocket.brocker.api.service.UserService;
import reactor.core.publisher.Mono;

@RSocketService(serviceInterface = UserService.class)
public class UserServiceImpl implements UserService {
    @Override
    public Mono<User> findById(Integer id) {
        return Mono.just(new User(1, "nick:" + id + "-" + this.toString().replace(this.getClass().getCanonicalName()+"@","")));
    }
}