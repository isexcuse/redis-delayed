package com.framework.redis.domain;

import java.io.Serializable;

/**
 * @author XiongFeiYang
 * @description 活动消息实体类
 * @createTime 2019-07-20 16:37
 **/
public class ActivityRedisKeyEntity implements Serializable {

    private static final long serialVersionUID = 586593824075086014L;

    /**
     * 当前活动状态
     */
    private Integer currentState;

    /**
     * 活动编号
     */
    private Long activityId;

    /**
     * 活动开始时间
     */
    private String activityStartTime;

    /**
     * 活动结束时间
     */
    private String activityEndTime;

    public ActivityRedisKeyEntity() {
    }

    public ActivityRedisKeyEntity(Integer currentState, Long activityId, String activityStartTime, String activityEndTime) {
        this.currentState = currentState;
        this.activityId = activityId;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    @Override
    public String toString() {
        return "ActivityRedisKeyEntity{" +
                "currentState=" + currentState +
                ", activityId=" + activityId +
                ", activityStartTime='" + activityStartTime + '\'' +
                ", activityEndTime='" + activityEndTime + '\'' +
                '}';
    }
}
