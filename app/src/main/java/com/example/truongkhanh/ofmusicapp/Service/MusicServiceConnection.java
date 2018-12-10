package com.example.truongkhanh.ofmusicapp.Service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.truongkhanh.ofmusicapp.Model.Song;

import java.util.ArrayList;

public class MusicServiceConnection {
    protected MusicService musicService;
    private boolean musicBound = false;
    private ArrayList<Song> songArrayList;
    private Context mcontext;
    private Intent mService;

    public MusicServiceConnection(Context context, ArrayList<Song> songs){
        songArrayList = songs;
        this.mcontext = context;
    }

    // Connection thiết lập để connect với musicservice và musicbinder do ta tạo ra
    public ServiceConnection MusicConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder)service;
            // Get service
            musicService = binder.getService();
            // Send Data
            musicService.getData(songArrayList);
            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound = false;
        }
    };

    public void attachService(){
        mService = new Intent(mcontext, MusicService.class);
        mcontext.bindService(mService, MusicConnection, Context.BIND_AUTO_CREATE);
    }

    public void detachService(){
        mcontext.unbindService(MusicConnection);
    }

    public boolean isMusicBound() {
        return musicBound;
    }

    public MusicService getMusicService(){
        return musicService;
    }
}
