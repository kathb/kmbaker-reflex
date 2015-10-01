package com.ualberta.kmbaker.kmbaker_reflex;

/**
 * Created by kmbaker on 9/28/15.
 *
 * This file is part of kmbaker-reflex.

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
public class GameShowStats {
    private Integer twoPlayers1;
    private Integer twoPlayers2;
    private Integer threePlayers1;
    private Integer threePlayers2;
    private Integer threePlayers3;
    private Integer fourPlayers1;
    private Integer fourPlayers2;
    private Integer fourPlayers3;
    private Integer fourPlayers4;

    public GameShowStats() {
        twoPlayers1 = 0;
        twoPlayers2 = 0;
        threePlayers1 = 0;
        threePlayers2 = 0;
        threePlayers3 = 0;
        fourPlayers1 = 0;
        fourPlayers2 = 0;
        fourPlayers3 = 0;
        fourPlayers4 = 0;
    }

    public void addStat(Integer button, Integer players) {
        if (players == 2 && button == 1) {
            twoPlayers1 = twoPlayers1 + 1;
        }
        else if (players == 2 && button == 2) {
            twoPlayers2 = twoPlayers2 + 1;
        }
        else if (players == 3 && button == 1) {
            threePlayers1 = threePlayers1 + 1;
        }
        else if (players == 3 && button == 2) {
            threePlayers2 = threePlayers2 + 1;
        }
        else if (players == 3 && button == 3) {
            threePlayers3 = threePlayers3 + 1;
        }
        else if (players == 4 && button == 1) {
            fourPlayers1 = fourPlayers1 + 1;
        }
        else if (players == 4 && button == 2) {
            fourPlayers2 = fourPlayers2 + 1;
        }
        else if (players == 4 && button == 3) {
            fourPlayers3 = fourPlayers3 + 1;
        }
        else if (players == 4 && button == 4) {
            fourPlayers4 = fourPlayers4 + 1;
        }
    }

    public void clearGameShowStats() {
        this.twoPlayers1 = 0;
        this.twoPlayers2 = 0;
        this.threePlayers1 = 0;
        this.threePlayers2 = 0;
        this.threePlayers3 = 0;
        this.fourPlayers1 = 0;
        this.fourPlayers2 = 0;
        this.fourPlayers3 = 0;
        this.fourPlayers4 = 0;
    }

    public Integer getTwoPlayers1() {
        return twoPlayers1;
    }

    public Integer getTwoPlayers2() {
        return twoPlayers2;
    }

    public Integer getThreePlayers1() {
        return threePlayers1;
    }

    public Integer getThreePlayers2() {
        return threePlayers2;
    }

    public Integer getThreePlayers3() {
        return threePlayers3;
    }

    public Integer getFourPlayers1() {
        return fourPlayers1;
    }

    public Integer getFourPlayers2() {
        return fourPlayers2;
    }

    public Integer getFourPlayers3() {
        return fourPlayers3;
    }

    public Integer getFourPlayers4() {
        return fourPlayers4;
    }

    public void setTwoPlayers1(Integer i) {
        twoPlayers1 = i;
    }

    public void setTwoPlayers2(Integer i) {
        twoPlayers2 = i;
    }

    public void setThreePlayers1(Integer i) {
        threePlayers1 = i;
    }

    public void setThreePlayers2(Integer i) {
        threePlayers2 = i;
    }

    public void setThreePlayers3(Integer i) {
        threePlayers3 = i;
    }

    public void setFourPlayers1(Integer i) {
        fourPlayers1 = i;
    }

    public void setFourPlayers2(Integer i) {
        fourPlayers2 = i;
    }

    public void setFourPlayers3(Integer i) {
        fourPlayers3 = i;
    }

    public void setFourPlayers4(Integer i) {
        fourPlayers4 = i;
    }
}
