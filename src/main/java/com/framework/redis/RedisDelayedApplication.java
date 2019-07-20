package com.framework.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author XiongFeiYang
 * @description SpringBoot 启动类
 * @createTime 2019-07-20 13:56
 **/
@SpringBootApplication
public class RedisDelayedApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDelayedApplication.class, args);
    }

}
