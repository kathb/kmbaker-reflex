package com.ualberta.kmbaker.kmbaker_reflex;

/**
 * Created by kmbaker on 9/25/15.
 * A timer for the single user reflex
 * Not finished
 */
public class ReflexTimer {
    private long startTime;
    private long endTime;

    public ReflexTimer() {
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

}
