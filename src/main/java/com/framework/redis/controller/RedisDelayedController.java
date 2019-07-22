package com.framework.redis.controller;

import com.framework.redis.api.ApiResponse;
import com.framework.redis.domain.ActivityRedisKeyEntity;
import com.framework.redis.domain.RedisCacheActuator;
import com.framework.redis.service.RedisDelayedService;
import io.swagger.annotations.Api;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiongFeiYang
 * @description Redis延时处理测试入口
 * @createTime 2019-07-20 15:17
 **/
@Api(description = "Redis延时处理测试入口")
@RestController
@RequestMapping("/redis")
public class RedisDelayedController {

    @Autowired
    private RedisDelayedService redisDelayedService;

    @GetMapping("/delayed")
    public ApiResponse startExecute(String body, long time) {
        redisDelayedService.delayedCache(RedisCacheActuator.execute(redisKeyEntity(), body, time));
        return ApiResponse.buildResponse(HttpStatus.SC_OK, "success");
    }


    @DeleteMapping("/delete")
    public ApiResponse deleteCache() {
        redisDelayedService.deleteCache(RedisCacheActuator.delete(redisKeyEntity()));
        return ApiResponse.buildResponse(HttpStatus.SC_OK, "success");
    }

    private ActivityRedisKeyEntity redisKeyEntity() {
        ActivityRedisKeyEntity keyEntity = new ActivityRedisKeyEntity();
        keyEntity.setActivityId(123456L);
        keyEntity.setCurrentState(2);
        keyEntity.setActivityStartTime("2019-07-22 10:00");
        keyEntity.setActivityEndTime("2019-07-20 10:30");
        return keyEntity;
    }

}
