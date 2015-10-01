package com.ualberta.kmbaker.kmbaker_reflex;

/**
 * Created by kmbaker on 9/25/15.
 * A timer for the single user reflex
 *
 *This file is part of kmbaker-reflex.
 *
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
