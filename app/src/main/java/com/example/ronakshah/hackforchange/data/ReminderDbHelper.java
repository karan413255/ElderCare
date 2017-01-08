package com.example.ronakshah.hackforchange.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ronakshah.hackforchange.data.ReminderContract.ReminderEntry;

public class ReminderDbHelper extends SQLiteOpenHelper
{
    private Context context;
    public final static String DATABASE_NAME = "remind.db";
    public final static int DATABASE_VERSION = 1;

    public ReminderDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_attend = "CREATE TABLE " + ReminderEntry.TABLE_NAME + " ("
                + ReminderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ReminderEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + ReminderEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, "
                + ReminderEntry.COLUMN_TIME + " TEXT NOT NULL, "
                + ReminderEntry.COLUMN_INTERVAL + " TEXT NOT NULL ); ";
        db.execSQL(CREATE_TABLE_attend);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ReminderEntry.TABLE_NAME + ";");
        onCreate(db);
    }

}

