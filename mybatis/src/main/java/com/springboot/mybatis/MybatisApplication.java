package com.springboot.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@SpringBootApplication
public class MybatisApplication {

    // 通过注解注入jedisPool对象
    @Autowired
    private JedisPool jedisPool;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String index() {
        String info = "Springboot程序已启动，请开始使用！";
        return info;
    }

    @RequestMapping(value = "/redis/{key}")
    public String testRedis(@PathVariable("key") String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }
}
