package com.ualberta.kmbaker.kmbaker_reflex;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


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
 */

public class testReflexActivity extends ActionBarActivity {
    private TextView text;
    private ReflexCountDownTimer countDown;
    private Context context = this;
    private Boolean timerDone = false;
    private ReflexTimer timer = new ReflexTimer();
    private Long time;
    private Integer randWait;
    private RandomWaitTime randWaitTime;
    private ListManager listManager = new ListManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_reflex);

        text = (TextView) findViewById(R.id.textView);
        playGame();
    }

    public void pushButton(View view) {
        Statistics stats = StatisticsSingleton.getStats();
        if (!timerDone) {
            countDown.cancel();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Too soon!")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // restarts timer
                            countDown.start();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        } else {
            // record end time
            // save in file

            timer.setEndTime();
            time = timer.getTimeInterval();
            //need to change types in statistics class to long
            stats.addTime(time);
            listManager.saveStatsInFile(this);
            setContentView(R.layout.activity_test_reflex);

            timerDone = false;
            startAgain();
        }
    }

    /* want to loop to allow to keep playing */
    public void playGame() {
        //timerDone = false;
        //set up random wait
        randWaitTime = new RandomWaitTime();
        randWait = randWaitTime.getRandWait();
        countDown = new ReflexCountDownTimer((long) randWait, 2000);

        displayWelcome();
    }

    /* Welcome alertDialog */
    public void displayWelcome() {
        /* http://www.mkyong.com/android/android-alert-dialog-example/ and
           https://developer.android.com/guide/topics/ui/dialogs.html
         */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("React fast! \nTap the button when told to.")
                .setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // starts timer
                        countDown.start();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /* Show alertDialog after playing the first time */
    public void startAgain() {
        randWait= randWaitTime.newRandWait();
        countDown = new ReflexCountDownTimer((long) randWait, 2000);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Your time: "+Long.toString(time)+"ms")
                .setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // starts timer
                        countDown.start();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_reflex, menu);
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

    /* http://developer.android.com/reference/android/os/CountDownTimer.html
    * https://androidcookbook.com/Recipe.seam;jsessionid=DF53064E03C7505C4EBF727E56E0728E?recipeId=1205 by Wagled Davids.
    * September 25, 2015. */
    public class ReflexCountDownTimer extends CountDownTimer{

        public ReflexCountDownTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }

        @Override
        public void onFinish()
        {
            text = (TextView) findViewById(R.id.textView);
            text.setText("Now!");
            timerDone = true;
            timer.setStartTime();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            /* don't do anything */
        }
    }
}
