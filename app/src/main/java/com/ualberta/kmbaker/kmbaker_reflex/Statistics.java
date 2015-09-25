package com.ualberta.kmbaker.kmbaker_reflex;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kmbaker on 9/25/15.
 */
public class Statistics {
    private ArrayList<Integer> allStats;
    private ArrayList<Integer> lastTen;
    private ArrayList<Integer> lastHundred;

    public Statistics() {
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
        Integer size = lastTen.size();
        Integer median;
        int index = size/2;
        if (size%2 == 0) {
            //even size
            median = (lastTen.get(index) + lastTen.get(index-1))/2;
        }
        else {
            //odd size
            median = lastTen.get(index);
        }
        return median;
    }

    public Integer getMedianHundred() {
        Integer size = lastHundred.size();
        Integer median;
        int index = size/2;
        if (size%2 == 0) {
            //even size
            median = (lastHundred.get(index) + lastHundred.get(index-1))/2;
        }
        else {
            //odd size
            median = lastHundred.get(index);
        }
        return median;
    }
    //one method for each list
    //getMedian
    //getMax i = Collections.max(arrayList)
    //getMin
    //getAverage

}
