package com.framework.redis.listener;

import com.alibaba.fastjson.JSONObject;
import com.framework.redis.domain.ActivityRedisKeyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;

/**
 * @author XiongFeiYang
 * @description Redis key失效 监听类
 * @createTime 2019-07-20 14:29
 **/
public class RedisMessageListener implements MessageListener {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RedisMessageListener.class);

    @Override
    public void onMessage(Message message, byte[] bytes) {
        logger.info("Redis Key 过期时间：" + LocalDateTime.now().toString());
        String messageBody = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        ActivityRedisKeyEntity keyEntity = JSONObject.parseObject(messageBody, ActivityRedisKeyEntity.class);
        logger.info("Redis Message Body：" + keyEntity);
    }
}
