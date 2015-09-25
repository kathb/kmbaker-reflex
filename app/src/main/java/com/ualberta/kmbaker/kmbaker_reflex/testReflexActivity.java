package com.ualberta.kmbaker.kmbaker_reflex;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class testReflexActivity extends ActionBarActivity {

    private TextView text;
    private ReflexCountDownTimer countDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_reflex);
        Intent intent = getIntent();//need this??

        text = (TextView) findViewById(R.id.textView);

        Button reflexButton = (Button) findViewById(R.id.reflexButton);
        reflexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                if (!timerDone) {
                    // timer hasn't gone off yet
                    // alertDialog
                }
            }
        });

        /* http://www.mkyong.com/android/android-alert-dialog-example/ and
            https://developer.android.com/guide/topics/ui/dialogs.html
         */
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
            //timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
        }

        @Override
        public void onTick(long millisUntilFinished) {
            /* don't do anything */
        }
    }
}
