package com.flysky.study.rsocket.brocker.api.service;

import com.flysky.study.rsocket.brocker.api.model.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> findById(Integer id);
}