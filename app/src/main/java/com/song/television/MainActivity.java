package com.song.television;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.song.api.TVShow;
import com.song.programlist.TVShowListView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TVShowListView tvShowListView = findViewById(R.id.tVShowListView);
        tvShowListView.addAll(initTVShowData(300));
        tvShowListView.setTvShowListViewListener(new TVShowListView.TVShowListViewListener() {
            @Override
            public boolean onClickByItem(TVShow tvShow) {
                Log.d(TAG, "preparePlay: " + tvShow.getName());
                return true;
            }
        });
    }

    public ArrayList<TVShow> initTVShowData(int num) {
        ArrayList<TVShow> tvShowArrayList = new ArrayList<>();
        URI uri = null;

        try {
            uri = new URI("http://39.135.138.59:18890/PLTV/88888910/224/3221225642/index.m3u8");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < num; i++) {
            tvShowArrayList.add(new TVShow(String.format("CCTV-%d", i), uri));
        }
        return tvShowArrayList;
    }
}