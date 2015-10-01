package com.ualberta.kmbaker.kmbaker_reflex;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by kmbaker on 9/30/15.
 *
 * Designed using the code added in lab 3 in lonelytwitter
 */
public class ListManager {

    private static final String STATSFILENAME = "statsfile.sav";
    private static final String BUZZERFILENAME = "buzzerfile.sav";
    private static Statistics stats = StatisticsSingleton.getStats();
    private static GameShowStats buzzer = GameShowStatsSingleton.getGameShowStats();

    public ListManager() {
    }

    public static void loadStatsFromFile(Context context) {
        try {
            FileInputStream fis = context.openFileInput(STATSFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<Statistics>() {}.getType();
            stats = gson.fromJson(in, listType);
            StatisticsSingleton.addStats(stats);

        } catch (FileNotFoundException e) {
            stats = new Statistics();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveStatsInFile(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(STATSFILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            stats = StatisticsSingleton.getStats();
            gson.toJson(stats, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadBuzzerFromFile(Context context) {
        try {
            FileInputStream fis = context.openFileInput(BUZZERFILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<GameShowStats>() {}.getType();
            buzzer = gson.fromJson(in, listType);
            GameShowStatsSingleton.addGameShowStats(buzzer);

        } catch (FileNotFoundException e) {
            //GameShowStats gameShowStats = GameShowStatsSingleton.getGameShowStats();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveBuzzerInFile(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(BUZZERFILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            buzzer = GameShowStatsSingleton.getGameShowStats();
            Gson gson = new Gson();
            gson.toJson(buzzer, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
