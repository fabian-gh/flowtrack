package de.fm.flowtrack.persistence;

import android.provider.BaseColumns;

public class TrackContract {

    public TrackContract(){}

    public static abstract class TrackEntry implements BaseColumns {
        public static final String TABLE_NAME = "tracks";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_DELETED = "deleted";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_NOTE = "note";
        public static final String COLUMN_LONGITUDE = "longitude";
        public static final String COLUMN_LATITUDE = "latitude";
        public static final String COLUMN_IMAGE = "image";

    }
}
