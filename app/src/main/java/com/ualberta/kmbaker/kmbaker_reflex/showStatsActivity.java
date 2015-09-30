package com.ualberta.kmbaker.kmbaker_reflex;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class showStatsActivity extends ActionBarActivity {

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
        /*http://stackoverflow.com/questions/3132889/action-sendto-for-sending-an-email sept 29,  Pierangelo Dal Ben and Teo Inke*/
        /*
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        Uri uri = Uri.parse("mailto:kmbaker@ualberta.ca");
        sendIntent.setData(uri);
        startActivity(Intent.createChooser(sendIntent, "Send email"));*/
    }

    public String getEmailText() {
        String email = "Hi!";;
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
