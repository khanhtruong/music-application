package com.example.truongkhanh.ofmusicapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toolbar;

import com.example.truongkhanh.ofmusicapp.Adapter.AllSongAdapter;
import com.example.truongkhanh.ofmusicapp.Adapter.TopAllSongAdapter;
import com.example.truongkhanh.ofmusicapp.Model.Song;
import com.example.truongkhanh.ofmusicapp.R;

import java.util.ArrayList;

public class AllTopSongActivity extends AppCompatActivity {

    ArrayList<Song> songArrayList = new ArrayList<>();
    RecyclerView recyclerViewAllSong;
    TopAllSongAdapter topAllSongAdapter;
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_top_song);

        mapping();
        getDataFromIntent();
        createNavBar();
    }

    private void createNavBar() {
        setActionBar(mToolBar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        getActionBar().setTitle("List Top Song");
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolBar.setTitleTextColor(Color.WHITE);
    }

    private void mapping() {
        recyclerViewAllSong = (RecyclerView) findViewById(R.id.RecyclerView_all_top_song);
        mToolBar = (Toolbar) findViewById(R.id.Toolbar_All_Top_Song_Activity);
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if(intent.hasExtra("ListTopSong")){
            songArrayList = intent.getParcelableArrayListExtra("ListTopSong");
        }

        topAllSongAdapter = new TopAllSongAdapter(songArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewAllSong.setLayoutManager(linearLayoutManager);
        recyclerViewAllSong.setAdapter(topAllSongAdapter);
    }
}
