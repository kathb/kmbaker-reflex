package com.ualberta.kmbaker.kmbaker_reflex;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class testReflexActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_reflex);
        Intent intent = getIntent();//need this??

        /* http://www.mkyong.com/android/android-alert-dialog-example/ and
            https://developer.android.com/guide/topics/ui/dialogs.html
         */
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("React fast! \nTap the button when told to.")
        .setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // does something??
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
}
