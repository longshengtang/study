package com.flysky.study.service.impl;

import com.flysky.study.model.User;
import com.flysky.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public User getUserById(Long userId) {

        Object o = redisTemplate.opsForValue().get(userId + "");
        if(o==null){
            return null;
        }

        return (User)o;
    }

    @Override
    public boolean save(User user) {

        Object o = redisTemplate.opsForValue().get(user.getId()+"");
        if (o != null) {
            return false;
        }

        redisTemplate.opsForValue().set(user.getId() + "", user);
        return true;
    }

    @Override
    public void remove(Long userId) {
        redisTemplate.delete(userId+"");
    }
}
