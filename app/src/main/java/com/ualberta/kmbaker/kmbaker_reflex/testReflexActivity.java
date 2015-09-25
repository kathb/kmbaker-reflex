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




public class testReflexActivity extends ActionBarActivity {
    private TextView text;
    private ReflexCountDownTimer countDown;
    private Context context = this;
    private Boolean timerDone;
    private Statistics stats = new Statistics();
    private ReflexTimer timer = new ReflexTimer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_reflex);
        Intent intent = getIntent();//need this??

        timerDone = false;
        text = (TextView) findViewById(R.id.textView);

        Button reflexButton = (Button) findViewById(R.id.reflexButton);
        reflexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                if (!timerDone) {
                    // timer hasn't gone off yet
                    // alertDialog to say too early
                    // restart timer
                    // stop timer
                    countDown.cancel();
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Too soon!")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // restarts timer???
                                    countDown.start();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    // record end time
                    // save in file

                    timer.setEndTime(System.currentTimeMillis());
                    Long time = timer.getTimeInterval();
                    //need to change types in statistics class to long
                    stats.addTime((Integer) time);
                    /* Testing Statistics class */
                    /*
                    stats.addTime(10);
                    stats.addTime(20);
                    stats.addTime(25);
                    setContentView(R.layout.activity_test_reflex);
                    TextView textView = (TextView) findViewById(R.id.textView2);
                    textView.setText(Integer.toString(stats.getMedianHundred())); */
                }
            }
        });

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

        /* Not sure if this should be in onResume() or onCreate() */
        Integer randWait = new RandomWaitTime().getRandWait();
        countDown = new ReflexCountDownTimer((long) randWait, 2000);


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
    * https://androidcookbook.com/Recipe.seam;jsessionid=DF53064E03C7505C4EBF727E56E0728E?recipeId=1205 */
    public class ReflexCountDownTimer extends CountDownTimer{

        public ReflexCountDownTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }

        @Override
        public void onFinish()
        {
            //text is
            text.setText("Now!");
            timerDone = true;
            timer.setStartTime(System.currentTimeMillis());
        }

        @Override
        public void onTick(long millisUntilFinished) {
            /* don't do anything */
        }
    }
}
