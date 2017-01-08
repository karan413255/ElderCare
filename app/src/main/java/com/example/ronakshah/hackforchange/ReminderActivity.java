package com.example.ronakshah.hackforchange;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ronakshah.hackforchange.data.ReminderContract.ReminderEntry;

import com.example.ronakshah.hackforchange.data.ReminderDbHelper;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import java.util.ArrayList;

public class ReminderActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cor);

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.four_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.health_item:

                        Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.reminder_item:
                        Intent i = new Intent(getApplicationContext(),ReminderActivity.class);
                        startActivity(i);
                        //Snackbar.make(coordinatorLayout, "Favorite Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.location_item:
                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.videos_item: {
                        Intent in =  new Intent(getApplicationContext(),Video.class);
                        startActivity(in);
//                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });

        bottomBar.setActiveTabColor("#C2185B");

        showData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.remind_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add) {
            Intent i = new Intent(this,addReminder.class);
            startActivityForResult(i,0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        showData();
    }

    private void showData()
    {
        ReminderDbHelper reminderDbHelper = new ReminderDbHelper(this);
        SQLiteDatabase dbRead = reminderDbHelper.getReadableDatabase();

        String projection[] = { ReminderEntry._ID,ReminderEntry.COLUMN_NAME,ReminderEntry.COLUMN_DESCRIPTION,
                ReminderEntry.COLUMN_TIME,ReminderEntry.COLUMN_INTERVAL};

        Cursor cursor = dbRead.query(ReminderEntry.TABLE_NAME, projection, null, null, null, null, null);

        int  i2, i3, i4,i5;
        i2 = cursor.getColumnIndex(ReminderEntry.COLUMN_NAME);
        i3 = cursor.getColumnIndex(ReminderEntry.COLUMN_DESCRIPTION);
        i4 = cursor.getColumnIndex(ReminderEntry.COLUMN_TIME);
        i5 = cursor.getColumnIndex(ReminderEntry.COLUMN_INTERVAL);
        ArrayList<RemindInfo> reminderInfos = new ArrayList<>();
        try {
            String c1,c2,c3,c4;

            while (cursor.moveToNext()) {
                c1 = cursor.getString(i2);
                c2 = cursor.getString(i3);
                c3 = cursor.getString(i4);
                c4 = cursor.getString(i5);
                reminderInfos.add(new RemindInfo(c1,c2,c3,c4));
            }
        }
        finally {
            cursor.close();
        }

        ListView lv  = (ListView) findViewById(R.id.remindView);
        ReminderAdapter mInfoAdap = new ReminderAdapter(this,reminderInfos, 0,lv);
        lv.setAdapter(mInfoAdap);
    }
}
