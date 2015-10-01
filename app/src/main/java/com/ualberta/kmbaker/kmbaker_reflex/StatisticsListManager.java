package com.ualberta.kmbaker.kmbaker_reflex;

import android.content.Context;

/**
 * Created by kmbaker on 10/1/15.
 */
public class StatisticsListManager {
    static String prefile = "Statistics";
    Context context;

    public StatisticsListManager(Context context) {
        this.context = context;
    }
    public Statistics loadStatisticsList() {
        //context.getSharedPreferences(prefile, node);
        return null;
    }

    public void saveStatisticsList(Statistics stats) {

    }
}
