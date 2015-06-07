package de.fm.flowtrack.persistence;

import de.fm.flowtrack.persistence.TrackContract.TrackEntry;

public class TrackDbRequestHelper {

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TrackEntry.TABLE_NAME + " (`" +
                    TrackEntry.COLUMN_ID + "` INTEGER PRIMARY KEY AUTOINCREMENT, `" +
                    TrackEntry.COLUMN_DELETED + "` INTEGER NOT NULL DEFAULT 0, `" +
                    TrackEntry.COLUMN_DATE + "` TEXT NOT NULL, `" +
                    TrackEntry.COLUMN_LATITUDE + "` REAL NOT NULL, `" +
                    TrackEntry.COLUMN_LONGITUDE + "` REAL NOT NULL, `" +
                    TrackEntry.COLUMN_NAME + "` TEXT NOT NULL, `" +
                    TrackEntry.COLUMN_DESCRIPTION + "` TEXT, `" +
                    TrackEntry.COLUMN_NOTE + "` TEXT )";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TrackEntry.TABLE_NAME;

    public static String getSqlCreateTable() {
        return SQL_CREATE_TABLE;
    }

    public static String getSqlDeleteTable() {
        return SQL_DELETE_TABLE;
    }
}
