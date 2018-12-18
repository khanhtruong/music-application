package com.example.truongkhanh.ofmusicapp.Fragment.Component_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truongkhanh.ofmusicapp.Adapter.rowSongMediaPlayerAdapter;
import com.example.truongkhanh.ofmusicapp.MediaPlayerActivity;
import com.example.truongkhanh.ofmusicapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListSongInMediaPlayerFragment extends Fragment {

    RecyclerView recyclerView;
    rowSongMediaPlayerAdapter rowSongAdapter;

    public ListSongInMediaPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_row_song_media, container, false);
        recyclerView = view.findViewById(R.id.RecyclerView_row_song_media);

        if(MediaPlayerActivity.songArrayList.size() > 0){
            // Mapping RecyclerView in Fragment with Adapter (rowSongMediaPlayerAdapter)
            rowSongAdapter = new rowSongMediaPlayerAdapter(MediaPlayerActivity.songArrayList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(rowSongAdapter);
        }

        return view;
    }

}
