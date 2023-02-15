package com.finallypro2.service;

import com.finallypro2.util.Result;

public interface RedisService {

    //获取用户的聊天记录
    public Result getRedis_message(Integer number,String people);

    public Result getGood_work(Integer number,String key);

    public Result putGood_work(String value,String key);
}
