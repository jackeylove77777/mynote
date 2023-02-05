package com.sangeng;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class WebTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("name","三更");
    }

    @Test
    public void testRedisGetValue(){
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
