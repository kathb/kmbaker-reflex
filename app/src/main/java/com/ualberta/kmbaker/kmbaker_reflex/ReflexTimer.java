package com.ualberta.kmbaker.kmbaker_reflex;

/**
 * Created by kmbaker on 9/25/15.
 * A timer for the single user reflex
 * Not finished
 */
public class ReflexTimer {
    private Long startTime;
    private Long endTime;

    public ReflexTimer() {
        startTime = 0L;
        endTime = 0L;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public Long getTimeInterval() {
        return endTime - startTime;
    }

}