package com.ualberta.kmbaker.kmbaker_reflex;

import java.util.Random;
/**
 * Created by kmbaker on 9/25/15.
 */
public class RandomWaitTime {
    private Integer randWait;
    private static final int MAX = 2000;
    private static final int MIN = 10;
    /* Random int in range http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java by Greg Case */
    Random rand;

    public RandomWaitTime() {
        /* Random int in range http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java by Greg Case */
        //Random rand = new Random();
        rand = new Random();
        this.randWait = rand.nextInt((MAX - MIN) + 1) + MIN;
    }

    public Integer getRandWait() {
        return randWait;
    }

    public Integer newRandWait() {
        this.randWait = rand.nextInt((MAX - MIN) + 1) + MIN;
        return randWait;
    }
}
