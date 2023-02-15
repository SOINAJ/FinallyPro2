package com.finallypro2.controller;

import com.finallypro2.POJO.Goods_work;
import com.finallypro2.POJO.Ready_work;
import com.finallypro2.POJO.Work_message;
import com.finallypro2.util.Code;
import com.finallypro2.util.RedisBean;
import com.finallypro2.util.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//@RestController
//@RequestMapping("/myredis")
@Component
public class TestRedis {


    private RedisTemplate redisTemplate;

//    public Result getRedis_message(Integer number,String people) {
//        redisTemplate = RedisBean.redis;
//        List<String> message = redisTemplate.opsForList().range(people,(number-1)*6,(number*6));
//        Integer oh = message != null ? Code.GET_OK : Code.GET_ERR;
//        String mes = message != null ? "RedisData" : "error";
//        return new Result(message,oh,mes);
//    }

    public void delRedisdate(String key) {
        redisTemplate = RedisBean.redis;
        redisTemplate.delete(key);
    }

    public List<Goods_work> getGood_work(Integer number, String key) {
        redisTemplate = RedisBean.redis;
        return redisTemplate.opsForList().range(key,number,number+5);
    }

    public void putGood_work(List<Goods_work> value, String key) {
        redisTemplate = RedisBean.redis;
        redisTemplate.opsForList().rightPushAll(key, value);
    }

    public List<Ready_work> getReady_work(Integer number, String key) {
        redisTemplate = RedisBean.redis;
        return redisTemplate.opsForList().range(key,number,number+5);
    }

    public void putReady_work(List<Ready_work> value, String key) {
        redisTemplate = RedisBean.redis;
        redisTemplate.opsForList().rightPushAll(key, value);
    }

    public List<Work_message> getWork_message(Integer number, String key) {
        redisTemplate = RedisBean.redis;
        return redisTemplate.opsForList().range(key,number,number+5);
    }

    public void putWork_message(List<Work_message> value, String key) {
        redisTemplate = RedisBean.redis;
        redisTemplate.opsForList().rightPushAll(key, value);
    }


//    @Autowired
//    private RedisService redisService;
//
//    @GetMapping("/{number}")
//    public Result getRedis_message(@PathVariable String number,String people){
//        return redisService.getRedis_message(Integer.parseInt(number),people);
//    }
}
