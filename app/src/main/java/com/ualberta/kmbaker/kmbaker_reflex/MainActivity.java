package com.ualberta.kmbaker.kmbaker_reflex;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends ActionBarActivity {

    private ListManager listManager = new ListManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        listManager.loadStatsFromFile(this); //have to call before setting up adapter
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    /*Respond to Single User button click
    * Must be public void and have a View as the only parameter*/
    public void testReflex(View view) {
        /*Do something - go to test reflex*/
        Intent intent = new Intent(this, testReflexActivity.class);
        startActivity(intent);
    }

    public void useBuzzer(View view) {
        /*Go to gameshow buzzer activity*/
        Intent intent = new Intent(this, useBuzzerActivity.class);
        startActivity(intent);
    }

    public void goToStats(View view) {
        /*Go to gameshow buzzer activity*/
        Intent intent = new Intent(this, showStatsActivity.class);
        startActivity(intent);
    }
}
