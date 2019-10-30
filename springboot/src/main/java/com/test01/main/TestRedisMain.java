package com.test01.main;

import com.test01.config.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class TestRedisMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);

//        redisTemplate.opsForGeo();
//        redisTemplate.opsForHyperLogLog();
//        redisTemplate.opsForList();
//        redisTemplate.opsForSet();
//        redisTemplate.opsForZSet();
//        redisTemplate.opsForValue().set("key1","value1");
//        redisTemplate.opsForHash().put("hash","field","hvalue");
//        redisTemplate.boundXXXXXX()

    }

    public void userRedisCallback(RedisTemplate redisTemplate){
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set("key2".getBytes(),"value2".getBytes());
                connection.hSet("hash".getBytes(),"field".getBytes(),"hvalue".getBytes());
                return null;
            }
        });
    }

    public void useSessionCallback(RedisTemplate redisTemplate){
        redisTemplate.execute(new SessionCallback(){
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.opsForValue().set("key2","value2");
                operations.opsForHash().put("hash","field","hvalue");
                return null;
            }
        });
    }
}
