package com.ualberta.kmbaker.kmbaker_reflex;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kmbaker on 9/25/15.
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

 Used: http://java67.blogspot.sg/2012/08/how-to-sort-arraylist-in-java-list.html
    for helping sorting an ArrayList. September 25, 2015.
 */
public class Statistics {
    private ArrayList<Long> allStats;
    private ArrayList<Long> lastTen;
    private ArrayList<Long> lastHundred;

    public Statistics() {
        allStats = new ArrayList<Long>();
        lastTen = new ArrayList<Long>();
        lastHundred = new ArrayList<Long>();
    }
    public ArrayList<Long> getAllStats(){
        return allStats;
    }

    public void setAllStats(ArrayList<Long> stats)
    {
        allStats = stats;
    }

    public ArrayList<Long> getLastTen(){
        return lastTen;
    }

    public void setLastTen(ArrayList<Long> stats)
    {
        lastTen = stats;
    }

    public ArrayList<Long> getLastHundred(){
        return lastHundred;
    }

    public void setLastHundred(ArrayList<Long> stats)
    {
        lastHundred = stats;
    }
    public void clearReflexStats() {
        allStats.clear();
        lastTen.clear();
        lastHundred.clear();
    }

    public void addTime(Long time) {
        allStats.add(time);
        /* sorting arrayList: http://java67.blogspot.sg/2012/08/how-to-sort-arraylist-in-java-list.html */
        Collections.sort(allStats);

        if (lastTen.size() < 10) {
            lastTen.add(time);
        }
        else {
            lastTen.remove(0);
            lastTen.add(time);
        }
        if (lastHundred.size() < 100) {
            lastHundred.add(time);
        }
        else {
            lastHundred.remove(0);
            lastHundred.add(time);
        }
    }

    public Long getMedianAll() {
        Integer size = allStats.size();
        if (size == 0) {
            return 0L;
        }
        Long median;
        int index = size/2;
        if (size%2 == 0) {
            //even size
            median = (allStats.get(index) + allStats.get(index-1))/2;
        }
        else {
            //odd size
            median = allStats.get(index);
        }
        return median;
    }
    public Long getMedianTen() {
        ArrayList<Long> sorted = lastTen;
        Integer size = sorted.size();
        if (size == 0) {
            return 0L;
        }
        Collections.sort(sorted);
        Long median;
        int index = size/2;
        if (size%2 == 0) {
            //even size
            median = (sorted.get(index) + sorted.get(index-1))/2;
        }
        else {
            //odd size
            median = sorted.get(index);
        }
        return median;
    }

    public Long getMedianHundred() {
        ArrayList<Long> sorted = lastHundred;
        Integer size = sorted.size();
        if (size == 0) {
            return 0L;
        }
        Collections.sort(sorted);
        Long median;
        int index = size/2;
        if (size%2 == 0) {
            //even size
            median = (sorted.get(index) + sorted.get(index-1))/2;
        }
        else {
            //odd size
            median = sorted.get(index);
        }
        return median;
    }

    public Long getMaxAll() {
        if (allStats.size() == 0) {
            return 0L;
        }
        return Collections.max(allStats);
    }

    public Long getMaxTen() {
        if (lastTen.size() == 0) {
            return 0L;
        }
        return Collections.max(lastTen);
    }

    public Long getMaxHundred() {
        if (lastHundred.size() == 0) {
            return 0L;
        }
        return Collections.max(lastHundred);
    }

    public Long getMinAll() {
        if (allStats.size() == 0) {
            return 0L;
        }
        return Collections.min(allStats);
    }

    public Long getMinTen() {
        if (lastTen.size() == 0) {
            return 0L;
        }
        return Collections.min(lastTen);
    }

    public Long getMinHundred() {
        if (lastHundred.size() == 0) {
            return 0L;
        }
        return Collections.min(lastHundred);
    }

    public Long getAverageAll() {
        Long average = 0L;
        Integer size = allStats.size();
        if (size == 0) {
            return 0L;
        }
        for (Long value: allStats) {
            average += value;
        }
        average = average/size;
        return average;
    }

    public Long getAverageTen() {
        Long average = 0L;
        Integer size = lastTen.size();
        if (size == 0) {
            return 0L;
        }
        for (Long value: lastTen) {
            average += value;
        }
        average = average/size;
        return average;
    }

    public Long getAverageHundred() {
        Long average = 0L;
        Integer size = lastHundred.size();
        if (size == 0) {
            return 0L;
        }
        for (Long value: lastHundred) {
            average += value;
        }
        average = average/size;
        return average;
    }
}
