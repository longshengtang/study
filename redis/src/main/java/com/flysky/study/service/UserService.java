package com.flysky.study.service;

import com.flysky.study.model.User;

public interface UserService {
    User getUserById(Long userId);

    boolean save(User user);

    void remove(Long userId);
}
