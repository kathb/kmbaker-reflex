package com.ualberta.kmbaker.kmbaker_reflex;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
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

 Used:
 http://developer.android.com/guide/components/intents-filters.html, September 29, 2015 for
 help making an Intent to send emails.

 */

public class showStatsActivity extends ActionBarActivity {

    private ListManager listManager = new ListManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stats);

        printGameShowStats();
        printReflexStats();
    }

    public void printReflexStats() {
        Statistics stats = StatisticsSingleton.getStats();

        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText("All: "+Long.toString(stats.getMinAll()));

        textView = (TextView) findViewById(R.id.textView6);
        textView.setText("Last 10: "+Long.toString(stats.getMinTen()));

        textView = (TextView) findViewById(R.id.textView7);
        textView.setText("Last 100: "+Long.toString(stats.getMinHundred()));

        textView = (TextView) findViewById(R.id.textView9);
        textView.setText("All: "+Long.toString(stats.getMaxAll()));

        textView = (TextView) findViewById(R.id.textView10);
        textView.setText("Last 10: "+Long.toString(stats.getMaxTen()));

        textView = (TextView) findViewById(R.id.textView11);
        textView.setText("Last 100: "+Long.toString(stats.getMaxHundred()));

        textView = (TextView) findViewById(R.id.textView13);
        textView.setText("All: "+Long.toString(stats.getAverageAll()));

        textView = (TextView) findViewById(R.id.textView14);
        textView.setText("Last 10: "+Long.toString(stats.getAverageTen()));

        textView = (TextView) findViewById(R.id.textView15);
        textView.setText("Last 100: "+Long.toString(stats.getAverageHundred()));

        textView = (TextView) findViewById(R.id.textView17);
        textView.setText("All: "+Long.toString(stats.getMedianAll()));

        textView = (TextView) findViewById(R.id.textView18);
        textView.setText("Last 10: "+Long.toString(stats.getMedianTen()));

        textView = (TextView) findViewById(R.id.textView19);
        textView.setText("Last 100: "+Long.toString(stats.getMedianHundred()));
    }

    /* change text views to show stats for gameshow buzzer */
    public void printGameShowStats() {
        GameShowStats gameShowStats = GameShowStatsSingleton.getGameShowStats();

        TextView textView = (TextView) findViewById(R.id.textView22);
        textView.setText("Player 1: "+Integer.toString(gameShowStats.getTwoPlayers1()));

        textView = (TextView) findViewById(R.id.textView23);
        textView.setText("Player 2: "+Integer.toString(gameShowStats.getTwoPlayers2()));

        textView = (TextView) findViewById(R.id.textView25);
        textView.setText("Player 1: "+Integer.toString(gameShowStats.getThreePlayers1()));

        textView = (TextView) findViewById(R.id.textView26);
        textView.setText("Player 2: "+Integer.toString(gameShowStats.getThreePlayers2()));

        textView = (TextView) findViewById(R.id.textView27);
        textView.setText("Player 3: "+Integer.toString(gameShowStats.getThreePlayers3()));

        textView = (TextView) findViewById(R.id.textView29);
        textView.setText("Player 1: "+Integer.toString(gameShowStats.getFourPlayers1()));

        textView = (TextView) findViewById(R.id.textView30);
        textView.setText("Player 2: "+Integer.toString(gameShowStats.getFourPlayers2()));

        textView = (TextView) findViewById(R.id.textView31);
        textView.setText("Player 3: "+Integer.toString(gameShowStats.getFourPlayers3()));

        textView = (TextView) findViewById(R.id.textView32);
        textView.setText("Player 4: "+Integer.toString(gameShowStats.getFourPlayers4()));
    }

    public void clearStats(View view) {
        GameShowStatsSingleton.getGameShowStats().clearGameShowStats();
        StatisticsSingleton.getStats().clearReflexStats();
        listManager.saveStatsInFile(this);
        listManager.saveBuzzerInFile(this);
        //add in clear reflex stats
        printGameShowStats();
        printReflexStats();
    }

    public void sendEmail(View view) {
        /* http://developer.android.com/guide/components/intents-filters.html */
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("message/rfc822");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, "user@something.ca");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Some stats for you");
        sendIntent.putExtra(Intent.EXTRA_TEXT, getEmailText());
        startActivity(Intent.createChooser(sendIntent, "send email"));
    }

    public String getEmailText() {
        Statistics stats = StatisticsSingleton.getStats();
        GameShowStats gameShowStats = GameShowStatsSingleton.getGameShowStats();
        String email = "My reaction times\nMinimum\nAll: "+Long.toString(stats.getMinAll()) +
                        "\t\tLast 10: "+ Long.toString(stats.getMinTen()) +
                        "\t\tLast 100: "+ Long.toString(stats.getMinHundred()) +
                        "\nMaximum\nAll: "+Long.toString(stats.getMaxAll()) +
                "\t\tLast 10: "+ Long.toString(stats.getMaxTen()) +
                "\t\tLast 100: "+ Long.toString(stats.getMaxHundred()) +
                "\nAverage\nAll: " + Long.toString(stats.getAverageAll()) +
                "\t\tLast 10: "+ Long.toString(stats.getAverageTen()) +
                "\t\tLast 100: "+ Long.toString(stats.getAverageHundred()) +
                "\nMedian\nAll: " + Long.toString(stats.getMedianAll()) +
                "\t\tLast 10: "+ Long.toString(stats.getMedianTen()) +
                "\t\tLast 100: "+ Long.toString(stats.getMedianHundred()) +
                "\n\nBuzzer counts\n2 Players:\n" + "Player 1: " + Integer.toString(gameShowStats.getTwoPlayers1()) +
                "\t\tPlayer 2: "+ Integer.toString(gameShowStats.getTwoPlayers2()) +
                "\n3 Players:\n" + "Player 1: " + Integer.toString(gameShowStats.getThreePlayers1()) +
                "\t\tPlayer 2: "+ Integer.toString(gameShowStats.getThreePlayers2()) +
                "\t\tPlayer 3: " + Integer.toString(gameShowStats.getThreePlayers3()) +
                "\n4 Players:\nPlayer 1: " + Integer.toString(gameShowStats.getFourPlayers1()) +
                "\t\tPlayer 2: " + Integer.toString(gameShowStats.getFourPlayers2()) +
                "\nPlayer 3: " + Integer.toString(gameShowStats.getFourPlayers3()) +
                "\t\tPlayer 4: " + Integer.toString(gameShowStats.getFourPlayers4());
        return email;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_stats, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
