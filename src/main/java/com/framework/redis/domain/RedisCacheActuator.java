package com.framework.redis.domain;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author XiongFeiYang
 * @description Redis缓存通用类
 * @createTime 2019-07-20 17:30
 **/
public class RedisCacheActuator<T> implements Serializable {

    private static final long serialVersionUID = -3702161262951829558L;

    /**
     * 缓存Key
     */
    private T cacheKey;

    /**
     * 缓存内容
     */
    private String cacheBody;

    /**
     * 有效期
     */
    private long expiration;

    /**
     * 有效期单位
     */
    private TimeUnit timeUnit;

    private RedisCacheActuator(T cacheKey) {
        this.cacheKey = cacheKey;
    }

    private RedisCacheActuator(T cacheKey, String cacheBody) {
        this.cacheKey = cacheKey;
        this.cacheBody = cacheBody;
    }

    private RedisCacheActuator(T cacheKey, String cacheBody, long expiration, TimeUnit timeUnit) {
        this.cacheKey = cacheKey;
        this.cacheBody = cacheBody;
        this.expiration = expiration;
        this.timeUnit = timeUnit;
    }

    /**
     * @description 通用缓存 
     * @author xiongfeiyang
     */
    public static <T> RedisCacheActuator<T> execute(T cacheKey, String cacheBody) {
        return new RedisCacheActuator<>(cacheKey, cacheBody);
    }

    /**
     * @description 有效期缓存 有效时间 单位默认毫秒
     * @author xiongfeiyang
     */
    public static <T> RedisCacheActuator<T> execute(T cacheKey, String cacheBody, long expiration) {
        return new RedisCacheActuator<>(cacheKey, cacheBody, expiration, TimeUnit.MILLISECONDS);
    }

    /**
     * @description 自定义缓存
     * @author xiongfeiyang
     */
    public static <T> RedisCacheActuator<T> execute(T cacheKey, String cacheBody, long expiration, TimeUnit timeUnit) {
        return new RedisCacheActuator<>(cacheKey, cacheBody, expiration, timeUnit);
    }
    
    /**
     * @description 删除缓存
     * @author xiongfeiyang
     */
    public static <T> RedisCacheActuator<T> delete(T cacheKey) {
        return new RedisCacheActuator<>(cacheKey);
    }

    public T getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(T cacheKey) {
        this.cacheKey = cacheKey;
    }

    public String getCacheBody() {
        return cacheBody;
    }

    public void setCacheBody(String cacheBody) {
        this.cacheBody = cacheBody;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
