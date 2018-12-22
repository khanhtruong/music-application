package com.example.truongkhanh.ofmusicapp.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.truongkhanh.ofmusicapp.Adapter.TabLayoutMainPageAdapter;
import com.example.truongkhanh.ofmusicapp.R;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    public static boolean musicBound = false;
    public static FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        InitPagerAdaptor();

        floatingActionButton.hide();
    }

    private void InitPagerAdaptor() {
        //Attach viewPager to Adapter
        TabLayoutMainPageAdapter homeFragmentAdapter =
                new TabLayoutMainPageAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(homeFragmentAdapter);

        //Attach tablayout to viewPager
        tabLayout.setupWithViewPager(viewPager);

        //Set icon for tabLayout
        tabLayout.getTabAt(0).setIcon(R.drawable.baseline_person_white_18dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.baseline_home_white_18dp);
    }

    private void Mapping() {
        viewPager = (ViewPager) findViewById(R.id.ViewPager_MainActivity);
        tabLayout = (TabLayout) findViewById(R.id.TabLayout_MainActivity);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.FloatingActionButtonComeBackToMediaPlayer);
    }


    public void onClickSearchBar(View view) {
        Intent intent = new Intent(view.getContext(), SearchActivity.class);
        startActivity(intent);
    }

    public void onClickTextView(View view) {
        Intent intent = new Intent(this, MediaPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
