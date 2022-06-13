package com.flysky.study.service;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void conn_test() {
        Jedis jedis = new Jedis("10.1.1.11", 6379);
        String ping = jedis.ping("hello ");
        System.out.println("ping = " + ping);

        for (String key : jedis.keys("*")) {
            System.out.println("key = " + key);
        }
    }
}
