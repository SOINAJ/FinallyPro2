package com.finallypro2.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RedisBean {
    @Autowired
    @Qualifier("MyredisTemplate")
    private RedisTemplate redisTemplate;
 
    public static RedisTemplate redis;
    @PostConstruct
    public void getRedisTemplate(){
        redis=this.redisTemplate;
    }
}
