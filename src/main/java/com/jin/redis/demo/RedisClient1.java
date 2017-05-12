package com.jin.redis.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Tuple;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * @author wu.jinqing
 * @date 2017年05月12日
 */
public class RedisClient1 {
    private static final String host = "127.90.0.1";
    private static final int port = 6371;
    private static final int timeout = 2000;
    private static final String password = "wujq4redis";

    public static void main(String[] args) {
        // You can store the pool somewhere statically, it is thread-safe.
        JedisPool pool = new JedisPool(new JedisPoolConfig(), host, port, timeout, password);

        /// Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
        try (Jedis jedis = pool.getResource()) {
//            jedis.set("wujq1", "zhangsan");
//
//            System.out.println(jedis.get("wujq1"));

            Set<Tuple> set = jedis.zrangeWithScores("myzset1", 0, -1);

            set.forEach( s -> System.out.println(s.getElement() + s.getScore()));
        }
/// ... when closing your application:
        pool.destroy();

    }
}


