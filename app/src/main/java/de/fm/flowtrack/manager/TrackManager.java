package de.fm.flowtrack.manager;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import de.fm.flowtrack.factory.TrackFactory;
import de.fm.flowtrack.model.Track;
import de.fm.flowtrack.persistence.TrackDbHelper;

public class TrackManager {

    private static TrackManager trackManager;
    private TrackFactory trackFactory;
    private List<Track> trackList;

    public static TrackManager getInstance() {
        if (trackManager == null) {
            trackManager = new TrackManager();
        }

        return trackManager;
    }

    public List<Track> getTracks(Context context) {
        Track track;
        TrackDbHelper trackDbHelper = new TrackDbHelper(context);
        Cursor cursor = trackDbHelper.getAllActive();

        if (trackFactory == null) {
            trackFactory = new TrackFactory();
        }

        if (trackList == null) {
            trackList = new ArrayList<Track>();
        }

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                track = trackFactory.createTrack(cursor.getInt(0),
                        false,
                        cursor.getString(2),
                        cursor.getDouble(3),
                        cursor.getDouble(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7));
                trackList.add(track);
            }
        }

        if (!cursor.isClosed()) {
            cursor.close();
        }

        return trackList;
    }
}
