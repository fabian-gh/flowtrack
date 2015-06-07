package de.fm.flowtrack.factory;

import de.fm.flowtrack.model.Track;

public class TrackFactory {

    public Track createTrack(int id, boolean deleted, String date, double latitude, double longitude,
                             String name, String description, String note){
        Track track = new Track();
        track.setId(id);
        track.setDeleted(deleted);
        track.setDate(date);
        track.setLatitude(latitude);
        track.setLongitude(longitude);
        track.setName(name);
        track.setDescription(description);
        track.setNote(note);

        return track;
    }
}
