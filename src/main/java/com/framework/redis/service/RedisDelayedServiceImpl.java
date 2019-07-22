package com.framework.redis.service;

import com.alibaba.fastjson.JSONObject;
import com.framework.redis.domain.ActivityRedisKeyEntity;
import com.framework.redis.domain.RedisCacheActuator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author XiongFeiYang
 * @description Redis延迟服务相关
 * @createTime 2019-07-20 14:47
 **/
@Service
public class RedisDelayedServiceImpl implements RedisDelayedService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static final String HANDLER_REDIS_KEY_HEAD = "HANDLER_REDIS_KEY_HEAD:";

    private static Logger logger = LoggerFactory.getLogger(RedisDelayedServiceImpl.class);

    @Override
    public void saveCache(RedisCacheActuator<ActivityRedisKeyEntity> actuator) {
        logger.info("通用缓存传输对象：" + actuator.toString());
        redisTemplate.opsForValue().set(HANDLER_REDIS_KEY_HEAD + JSONObject.toJSONString(actuator.getCacheKey()), actuator.getCacheBody());
    }

    @Override
    public void delayedCache(RedisCacheActuator<ActivityRedisKeyEntity> actuator) {
        logger.info("延时缓存传输对象：" + actuator.toString());
        long expiration = actuator.getExpiration();
        if (expiration <= 0) {
            this.saveCache(actuator);
            return;
        }
        String cacheKey = JSONObject.toJSONString(actuator.getCacheKey());
        redisTemplate.opsForValue().set(HANDLER_REDIS_KEY_HEAD + cacheKey, actuator.getCacheBody(), expiration, actuator.getTimeUnit());
    }

    @Override
    public void deleteCache(RedisCacheActuator<ActivityRedisKeyEntity> actuator) {
        redisTemplate.delete(HANDLER_REDIS_KEY_HEAD + JSONObject.toJSONString(actuator.getCacheKey()));
    }
}
