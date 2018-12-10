package com.example.truongkhanh.ofmusicapp.Fragment.Component_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truongkhanh.ofmusicapp.Adapter.rowSongDontCallActivityAdapter;
import com.example.truongkhanh.ofmusicapp.MediaPlayerActivity;
import com.example.truongkhanh.ofmusicapp.Model.Song;
import com.example.truongkhanh.ofmusicapp.R;

import java.util.ArrayList;
import java.util.SortedMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class RowSongMediaFragment extends Fragment {

    RecyclerView recyclerView;
    rowSongDontCallActivityAdapter rowSongAdapter;

    public RowSongMediaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_row_song_media, container, false);
        recyclerView = view.findViewById(R.id.RecyclerView_row_song_media);

        if(MediaPlayerActivity.songArrayList.size() > 0){
            // Mapping RecyclerView in Fragment with Adapter (rowSongDontCallActivityAdapter)
            Log.d("CCCCC5", "AAAAA5");
            rowSongAdapter = new rowSongDontCallActivityAdapter(MediaPlayerActivity.songArrayList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(rowSongAdapter);
        }

        return view;
    }

}
