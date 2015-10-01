package com.ualberta.kmbaker.kmbaker_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class fourPlayerActivity extends ActionBarActivity {
    private Context context = this;
    ListManager listManager = new ListManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_player);
    }

    public void clickButton1(View view) {
        //record button click
        GameShowStatsSingleton.getGameShowStats().addStat(1, 4);
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
        listManager.saveBuzzerInFile(this);
    }

    public void clickButton2(View view) {
        //record button click
        GameShowStatsSingleton.getGameShowStats().addStat(2, 4);
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
        listManager.saveBuzzerInFile(this);
    }

    public void clickButton3(View view) {
        //record button click
        GameShowStatsSingleton.getGameShowStats().addStat(3, 4);
        //display who clicked first
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Player 3 is first")
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //? start again ?
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        listManager.saveBuzzerInFile(this);
    }

    public void clickButton4(View view) {
        //record button click
        GameShowStatsSingleton.getGameShowStats().addStat(4, 4);
        //display who clicked first
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Player 4 is first")
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //? start again ?
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        listManager.saveBuzzerInFile(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_player, menu);
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
