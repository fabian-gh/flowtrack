package de.fm.flowtrack.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import de.fm.flowtrack.R;
import de.fm.flowtrack.adapter.TrackAdapter;
import de.fm.flowtrack.manager.TrackManager;
import de.fm.flowtrack.model.Track;

public class TrackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView recyclerView;
        TrackAdapter adapter;
        Context context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        recyclerView = (RecyclerView) findViewById(R.id.listing);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        List<Track> trackList = TrackManager.getInstance().getTracks(context);
        adapter = new TrackAdapter(trackList, R.layout.row_track, context);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.track, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addNewTrack(View view) {
        // handle click on plus button
    }
}
