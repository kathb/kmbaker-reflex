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

    public static void addGameShowStats(GameShowStats stats)
    {
        getGameShowStats().setTwoPlayers1(stats.getTwoPlayers1());
        /*getGameShowStats().setTwoPlayers2(stats.getTwoPlayers2());
        getGameShowStats().setThreePlayers1(stats.getThreePlayers1());
        getGameShowStats().setThreePlayers2(stats.getThreePlayers2());
        getGameShowStats().setThreePlayers3(stats.getThreePlayers3());
        getGameShowStats().setFourPlayers1(stats.getFourPlayers1());
        getGameShowStats().setFourPlayers2(stats.getFourPlayers2());
        getGameShowStats().setFourPlayers3(stats.getFourPlayers3());
        getGameShowStats().setFourPlayers4(stats.getFourPlayers4());*/
    }
}
