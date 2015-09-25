package com.ualberta.kmbaker.kmbaker_reflex;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kmbaker on 9/25/15.
 * Need to change Integers to Floats or Doubles???????
 */
public class Statistics {
    private ArrayList<Integer> allStats;
    private ArrayList<Integer> lastTen;
    private ArrayList<Integer> lastHundred;

    public Statistics() {
        allStats = new ArrayList<Integer>();
        lastTen = new ArrayList<Integer>();
        lastHundred = new ArrayList<Integer>();
    }

    public void addTime(Integer time) {
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

    public Integer getMedianAll() {
        Integer size = allStats.size();
        Integer median;
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
    public Integer getMedianTen() {
        ArrayList<Integer> sorted = lastTen;
        Collections.sort(sorted);
        Integer size = sorted.size();
        Integer median;
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

    public Integer getMedianHundred() {
        ArrayList<Integer> sorted = lastHundred;
        Collections.sort(sorted);
        Integer size = sorted.size();
        Integer median;
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

    public Integer getMaxAll() {
        return Collections.max(allStats);
    }

    public Integer getMaxTen() {
        return Collections.max(lastTen);
    }

    public Integer getMaxHundred() {
        return Collections.max(lastHundred);
    }

    public Integer getMinAll() {
        return Collections.min(allStats);
    }

    public Integer getMinTen() {
        return Collections.min(lastTen);
    }

    public Integer getMinHundred() {
        return Collections.min(lastHundred);
    }

    public Integer getAverageAll() {
        Integer average = 0;
        Integer size = allStats.size();
        for (Integer value: allStats) {
            average += value;
        }
        average = average/size;
        return average;
    }

    public Integer getAverageTen() {
        Integer average = 0;
        Integer size = lastTen.size();
        for (Integer value: lastTen) {
            average += value;
        }
        average = average/size;
        return average;
    }

    public Integer getAverageHundred() {
        Integer average = 0;
        Integer size = lastHundred.size();
        for (Integer value: lastHundred) {
            average += value;
        }
        average = average/size;
        return average;
    }
}
