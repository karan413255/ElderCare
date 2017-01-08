package com.example.ronakshah.hackforchange.data;

/**
 * Created by Ronak Shah on 25-12-2016.
 */

import android.provider.BaseColumns;

public class ReminderContract {
    public ReminderContract() {}

    public static final class ReminderEntry implements BaseColumns
    {
        public final static String TABLE_NAME = "reminders";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "reminderName";
        public final static String COLUMN_DESCRIPTION = "description";
        public final static String COLUMN_TIME = "time";
        public final static String COLUMN_INTERVAL = "interval";
    }
}
