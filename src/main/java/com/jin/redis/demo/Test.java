package com.jin.redis.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
 * @author wu.jinqing
 * @date 2017年05月12日
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-redis.xml");

//        Example example = ctx.getBean(Example.class);
//
//
//        System.out.println(example.get("wujq1"));

        RedisStringTest test = ctx.getBean(RedisStringTest.class);
//
//
//
//        System.out.println(test.get("wujq1"));
//        test.set("wujq2", "ma zi");

        Set<ZSetOperations.TypedTuple<String>> set = test.rangeWithScores("myzset1", 0, -1);

        set.forEach(s -> {
            System.out.println("member: " + s.getValue() + ", score: " + s.getScore());
        });

//        test.zadd();

        System.out.println("end");
    }
}
