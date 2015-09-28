package com.ualberta.kmbaker.kmbaker_reflex;

/**
 * Created by kmbaker on 9/28/15.
 */
public class GameShowStatsSingleton {
    private static GameShowStats gameShowStats = null;

    public static GameShowStats getGameShowStats() {
        if (gameShowStats == null) {
            gameShowStats = new GameShowStats();
        }
        return gameShowStats;
    }
}
