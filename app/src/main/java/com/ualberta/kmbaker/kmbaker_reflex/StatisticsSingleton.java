package com.ualberta.kmbaker.kmbaker_reflex;

import java.util.ArrayList;

/**
 * Created by kmbaker on 9/28/15.
 * Singleton like Abram Hindle in video 7 student picker
 */
public class StatisticsSingleton {
    private static Statistics stats = null;

    public static Statistics getStats() {
        if (stats == null) {
            stats = new Statistics();
        }
        return stats;
    }
    public static void addStats(Statistics statArrays)
    {
        getStats().setAllStats(statArrays.getAllStats());
        getStats().setLastTen(statArrays.getLastTen());
        getStats().setLastHundred(statArrays.getLastHundred());
    }
}
