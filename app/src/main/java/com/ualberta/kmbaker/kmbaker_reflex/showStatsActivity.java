package com.ualberta.kmbaker.kmbaker_reflex;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class showStatsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stats);

        printGameShowStats();

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
