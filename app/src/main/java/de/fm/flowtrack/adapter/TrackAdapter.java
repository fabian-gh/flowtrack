package de.fm.flowtrack.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.fm.flowtrack.R;
import de.fm.flowtrack.model.Track;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> trackList;
    private int rowLayout;
    private Context context;

    public TrackAdapter(List<Track> trackList, int rowLayout, Context context) {
        this.trackList = trackList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Track track = trackList.get(i);
        viewHolder.trackName.setText(track.getName());
        viewHolder.trackDate.setText(track.getDate());
        viewHolder.trackDescription.setText(track.getDescription());
        viewHolder.trackNote.setText(track.getNote());
//        viewHolder.trackImage.setImageDrawable(context.getDrawable(track.getImageResourceId(context)));
    }

    @Override
    public int getItemCount() {
        return trackList == null ? 0 : trackList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView trackName;
        public TextView trackDate;
        public TextView trackDescription;
        public TextView trackNote;
        public ImageView trackImage;

        public ViewHolder(View itemView) {
            super(itemView);
            trackName = (TextView) itemView.findViewById(R.id.trackName);
            trackDate = (TextView) itemView.findViewById(R.id.trackDateTime);
            trackDescription = (TextView) itemView.findViewById(R.id.trackDescription);
            trackNote = (TextView) itemView.findViewById(R.id.trackNote);
//            trackImage = (ImageView)itemView.findViewById(R.id.trackImage);
        }

    }
}
