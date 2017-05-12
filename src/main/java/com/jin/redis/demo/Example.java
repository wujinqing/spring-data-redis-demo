package com.jin.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URL;

/**
 * @author wu.jinqing
 * @date 2017年05月12日
 */
@Component
public class Example {
    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    public void addLink(String userId, URL url) {
        listOps.leftPush(userId, url.toExternalForm());
        // or use template directly
        template.boundListOps(userId).leftPush(url.toExternalForm());
    }

    public String get(String key) {
        return template.boundValueOps(key).get();
    }

    public void set(String key, String value) {
        template.boundValueOps(key).set(value);
    }
}
