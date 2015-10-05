package com.ualberta.kmbaker.kmbaker_reflex;

import java.util.Random;
/**
 * Created by kmbaker on 9/25/15.
 * This class generates random wait times for the reflex timer.
 *
 * This file is part of kmbaker-reflex.
 *
 *  kmbaker-reflex is free software: you can redistribute it and/or modify
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
public class RandomWaitTime {
    private Integer randWait;
    private static final int MAX = 2000;
    private static final int MIN = 10;
    Random rand;

    public RandomWaitTime() {
        /* Random int in range http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java by Greg Case */
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
