package com.example.truongkhanh.ofmusicapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toolbar;

import com.example.truongkhanh.ofmusicapp.Adapter.AllSongAdapter;
import com.example.truongkhanh.ofmusicapp.Model.Song;

import java.util.ArrayList;

public class AllOfflineSongActivity extends AppCompatActivity {

    ArrayList<Song> songArrayList = new ArrayList<>();
    RecyclerView recyclerViewAllSong;
    AllSongAdapter allSongAdapter;
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_offline_song);

        mapping();
        getDataFromIntent();
        createNavBar();
    }

    private void createNavBar() {
        setActionBar(mToolBar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        getActionBar().setTitle("List Song");
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolBar.setTitleTextColor(Color.WHITE);
    }

    private void mapping() {
        recyclerViewAllSong = (RecyclerView) findViewById(R.id.RecyclerView_all_song);
        mToolBar = (Toolbar) findViewById(R.id.Toolbar_All_Song_Activity);
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if(intent.hasExtra("ListSong")){
            songArrayList = intent.getParcelableArrayListExtra("ListSong");
        }

        allSongAdapter = new AllSongAdapter(songArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewAllSong.setLayoutManager(linearLayoutManager);
        recyclerViewAllSong.setAdapter(allSongAdapter);
    }
}
