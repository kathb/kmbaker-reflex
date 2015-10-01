package com.ualberta.kmbaker.kmbaker_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class twoPlayerActivity extends ActionBarActivity {
    private Context context = this;
    private ListManager listManager = new ListManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

    }


    public void clickButton1(View view) {
        //record button click
        GameShowStatsSingleton.getGameShowStats().addStat(1, 2);
        //listManager.saveGameShowInFile(context);
        //display who clicked first
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Player 1 is first")
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //? start again ?
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void clickButton2(View view) {
        //record button click
        GameShowStatsSingleton.getGameShowStats().addStat(2, 2);
        //listManager.saveGameShowInFile(context);
        //display who clicked first
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Player 2 is first")
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //? start again ?
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_player, menu);
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
