package com.framework.redis.service;

import com.framework.redis.domain.ActivityRedisKeyEntity;
import com.framework.redis.domain.RedisCacheActuator;

/**
 * @author XiongFeiYang
 * @description Redis延迟服务
 * @createTime 2019-07-20 14:13
 **/
public interface RedisDelayedService {

    /**
     * @description 通用缓存
     * @author xiongfeiyang
     * @date 2019/7/20 14:59
     * @params [key, body]
     * @return void
     */
    void saveCache(RedisCacheActuator<ActivityRedisKeyEntity> actuator);

    /**
     * @description 有效期内缓存 单位/毫秒
     * @author xiongfeiyang
     * @date 2019/7/20 14:59
     * @params [key, body, time]
     * @return void
     */
    void delayedCache(RedisCacheActuator<ActivityRedisKeyEntity> actuator);

    /**
     * @description 删除缓存
     * @author xiongfeiyang
     * @date 2019/7/20 16:42
     * @params [key]
     * @return void
     */
    void deleteCache(RedisCacheActuator<ActivityRedisKeyEntity> actuator);

}
