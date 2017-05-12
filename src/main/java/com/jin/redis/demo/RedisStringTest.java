package com.jin.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author wu.jinqing
 * @date 2017年05月12日
 */
@Component
public class RedisStringTest {
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Resource(name = "stringRedisTemplate")
//    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, String> zSetOperations;


    public Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String k, long s, long e)
    {

        Set<ZSetOperations.TypedTuple<String>> set = zSetOperations.rangeWithScores(k, s, e);
        return set;
    }


    public void zadd()
    {
        boolean b = zSetOperations.add("myzset2", "w", 102);

        System.out.println("zadd: " + b);
    }

//    public String get(String k)
//    {
////        return redisTemplate.boundValueOps(k).get();
//
//        return  valueOperations.get(k);
//    }
//
//    public void set(String k, String v)
//    {
//        valueOperations.set(k, v);
//    }
}
