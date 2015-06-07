package de.fm.flowtrack.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class TrackDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Tracks.db";

    public TrackDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TrackDbRequestHelper.getSqlCreateTable());
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(TrackDbRequestHelper.getSqlDeleteTable());
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    public Cursor getAllActive(){
        SQLiteDatabase dbRead = getReadableDatabase();
        String sortOrder = TrackContract.TrackEntry.COLUMN_DATE + " ASC";

        return dbRead.query(
                TrackContract.TrackEntry.TABLE_NAME,  // The table to query
                null,                                 // The columns to return (this case all)
                "deleted = ?",                        // The columns for the WHERE clause
                new String[]{"0"},                    // The values for the WHERE clause
                null,                                 // don't group the rows
                null,                                 // don't filter by row groups
                sortOrder                             // The sort order
        );
    }

}
