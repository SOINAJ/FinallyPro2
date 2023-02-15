package com.finallypro2.service.impt;

import com.finallypro2.POJO.Goods_work;
import com.finallypro2.service.RedisService;
import com.finallypro2.util.Code;
import com.finallypro2.util.RedisBean;
import com.finallypro2.util.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpt implements RedisService {

    private RedisTemplate redisTemplate;

    @Override
    public Result getRedis_message(Integer number,String people) {
        redisTemplate = RedisBean.redis;
        List<String> message = redisTemplate.opsForList().range(people,(number-1)*6,(number*6));
        Integer oh = message != null ? Code.GET_OK : Code.GET_ERR;
        String mes = message != null ? "RedisData" : "error";
        return new Result(message,oh,mes);
    }

    @Override
    public Result getGood_work(Integer number, String key) {
        redisTemplate = RedisBean.redis;
        List<Goods_work> workList = redisTemplate.opsForList().range(key,(number-1)*6,(number*6));
        Integer oh = workList != null ? Code.GET_OK : Code.GET_ERR;
        String mes = workList != null ? "RedisData" : "error";
        return new Result(workList,oh,mes);
    }

    @Override
    public Result putGood_work(String value, String key) {
        redisTemplate = RedisBean.redis;
        Long aLong = redisTemplate.opsForList().rightPush(key, value);
        Integer oh = aLong != null ? Code.GET_OK : Code.GET_ERR;
        String mes = aLong != null ? "RedisData" : "error";
        return new Result(aLong,oh,mes);
    }


}
