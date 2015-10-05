package com.ualberta.kmbaker.kmbaker_reflex;

/**
 * Created by kmbaker on 9/28/15.
 * Modeled after the singleton from Abram Hindle's Youtube videos Student Picker for Android.
 *
 This file is part of kmbaker-reflex.

 kmbaker-reflex is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 kmbaker-reflex is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with kmbaker-reflex.  If not, see <http://www.gnu.org/licenses/>.

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
        getGameShowStats().setTwoPlayers2(stats.getTwoPlayers2());
        getGameShowStats().setThreePlayers1(stats.getThreePlayers1());
        getGameShowStats().setThreePlayers2(stats.getThreePlayers2());
        getGameShowStats().setThreePlayers3(stats.getThreePlayers3());
        getGameShowStats().setFourPlayers1(stats.getFourPlayers1());
        getGameShowStats().setFourPlayers2(stats.getFourPlayers2());
        getGameShowStats().setFourPlayers3(stats.getFourPlayers3());
        getGameShowStats().setFourPlayers4(stats.getFourPlayers4());
    }
}
