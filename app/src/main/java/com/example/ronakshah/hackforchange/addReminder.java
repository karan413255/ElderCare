package com.example.ronakshah.hackforchange;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ronakshah.hackforchange.data.ReminderContract;
import com.example.ronakshah.hackforchange.data.ReminderDbHelper;

import java.util.Calendar;

public class addReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button b  = (Button)findViewById(R.id.save);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText) findViewById(R.id.rname);
                EditText e2 = (EditText) findViewById(R.id.rdescription);
                EditText e3 = (EditText) findViewById(R.id.rtime);
                EditText e4 = (EditText) findViewById(R.id.rdate);

                ReminderDbHelper timeTableDbHelper = new ReminderDbHelper(getApplicationContext());
                SQLiteDatabase add = timeTableDbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                String t1, t2, t3, t4;

                t1 = e1.getText().toString().trim();
                t2 = e2.getText().toString().trim();
                t3 = e3.getText().toString().trim();
                t4 = e4.getText().toString().trim();

                contentValues.put(ReminderContract.ReminderEntry.COLUMN_NAME, t1);
                contentValues.put(ReminderContract.ReminderEntry.COLUMN_DESCRIPTION, t2);
                contentValues.put(ReminderContract.ReminderEntry.COLUMN_TIME, t3);
                contentValues.put(ReminderContract.ReminderEntry.COLUMN_INTERVAL, t4);
                long x = add.insert(ReminderContract.ReminderEntry.TABLE_NAME, null, contentValues);
                System.out.println(x);
                remindersNotification(t3);
                finish();
            }
        });

      }
    public void remindersNotification(String t3)
    {
        Calendar c = Calendar.getInstance();
        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,0); //what is zero
        Notification noti = new Notification.Builder(getApplicationContext())
                .setTicker("Reminder Alert")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Reminder")

                .setContentIntent(pIntent).getNotification();

        noti.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0, noti); //what is zero

    }
}
