package com.ualberta.kmbaker.kmbaker_reflex;

import java.util.ArrayList;

/**
 * Created by kmbaker on 9/28/15.
 * Modeled after the singleton from Abram Hindle's Youtube videos Student Picker for Android.
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
