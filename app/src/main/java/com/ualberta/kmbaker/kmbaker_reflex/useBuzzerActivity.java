package com.ualberta.kmbaker.kmbaker_reflex;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/*
 This class displays an alertDialog for the user to choose how many players.

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

public class useBuzzerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_buzzer);

        Dialog dialog = onCreateDialog(savedInstanceState);
        dialog.show();
    }


    /* http://developer.android.com/guide/topics/ui/dialogs.html#AddingAList */
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick the number of players")
                .setItems(R.array.players, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        if (which == 0) {
                            //need 2 buttons
                            useTwoPlayers();
                        } else if (which == 1) {
                            useThreePlayers();
                        } else if (which == 2) {
                            useFourPlayers();
                        }
                    }
                });
        return builder.create();
    }

    public void useTwoPlayers() {
        Intent intent = new Intent(this, twoPlayerActivity.class);
        startActivity(intent);
    }
    public void useThreePlayers() {
        Intent intent = new Intent(this, threePlayerActivity.class);
        startActivity(intent);
    }
    public void useFourPlayers() {
        Intent intent = new Intent(this, fourPlayerActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_use_buzzer, menu);
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
