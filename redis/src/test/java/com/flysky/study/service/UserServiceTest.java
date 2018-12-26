package com.flysky.study.service;


import com.flysky.study.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() {

        User u = new User().setId(10000L);
//        assertTrue(userService.save(u));
//
//        User user = userService.getUserById(u.getId());
//        assertEquals(u, user);

        userService.remove(u.getId());

    }

}
