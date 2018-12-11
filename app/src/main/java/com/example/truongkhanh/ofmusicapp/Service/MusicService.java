package com.example.truongkhanh.ofmusicapp.Service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import com.example.truongkhanh.ofmusicapp.Model.Song;
import com.example.truongkhanh.ofmusicapp.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.example.truongkhanh.ofmusicapp.MediaPlayerActivity.btnStart;
import static com.example.truongkhanh.ofmusicapp.MediaPlayerActivity.mSeekbarUpdateHandler;
import static com.example.truongkhanh.ofmusicapp.MediaPlayerActivity.mUpdateSeekbar;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener{

    private boolean mRandom = false;
    private boolean mRepeat = true;
    private MediaPlayer mMediaPlayer;
    private ArrayList<Song> songs;
    private int songPosition;
    private final IBinder musicBinder = new MusicBinder();

    public MusicService() {
    }

    public void onCreate(){
        super.onCreate();
        mMediaPlayer = new MediaPlayer();
        songPosition = 0;

        initMusicPlayer();
    }

    private void initMusicPlayer() {
        mMediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setOnErrorListener(this);
        mMediaPlayer.setOnPreparedListener(this);
    }

    public void getData(ArrayList<Song> songs){
        this.songs = songs;
    }

    public int getSongPosition(){
        return songPosition;
    }

    public class MusicBinder extends Binder{
        public MusicService getService(){
            return MusicService.this;
        }
    }

    public void PlaySong() {
        mMediaPlayer.stop();
        mMediaPlayer.reset();
        Song playSong = songs.get(songPosition);
        try{
            mMediaPlayer.setDataSource(playSong.getPathSong());
        }catch (Exception e){
            Log.e("MusicService", "Error setting Data Source", e);
        }
        // Sau khi truyền vào được bài hát, ta gọi phương thức này để chuẩn bị phát nhạc
        try {
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }


    }

    // Phương thức onPrepared được gọi để play nhạc
    @Override
    public void onPrepared(MediaPlayer mp){
        mp.start();
    }

    // Phương thức để thay đổi bài hát khác
    public void setSong(int songIndex){
        if(mRandom){
            songPosition = new Random().nextInt(songs.size());
        } else {
            songPosition = songIndex;
        }
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
//        Log.d("KhanhAAA", String.valueOf(songPosition));
        playNext();
    }

    public void pauseSong(){
        mMediaPlayer.pause();
        mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
    }

    public void playSong(){
        mMediaPlayer.start();
        mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar, 50);
    }

    public int timeSong(){
        return mMediaPlayer.getDuration();
    }

    public int currentPosition(){
        return mMediaPlayer.getCurrentPosition();
    }

    public void setProgressMediaPlayer(int progress){
        mMediaPlayer.seekTo(progress);
    }

    public void playBack(){
        if(songPosition > 0){
            setSong(songPosition - 1);
            PlaySong();
        } else {
            setSong(songs.size()-1);
            PlaySong();
        }
    }

    public void playNext(){
        if(songPosition == songs.size() - 1){
            if(mRepeat){
                setSong(0);
                PlaySong();
            } else {
                mMediaPlayer.pause();
                btnStart.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24px);
            }
        } else {
            setSong(songPosition + 1);
            PlaySong();
        }
    }

    public MediaPlayer getmMediaPlayer(){
        return mMediaPlayer;
    }

    public boolean getmRandom(){
        return mRandom;
    }

    public boolean getmRepeat(){
        return mRepeat;
    }

    public void setmRandom(boolean random){
        this.mRandom = random;
    }

    public void setmRepeat(boolean repeat){
        this.mRepeat = repeat;
    }

    // Phuong thuc de tao Service
    // Tra ve Binder de?
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return this.musicBinder;
    }

    // Giai phong tai nguyen sau khi Huy doi tuong Service
    @Override
    public boolean onUnbind(Intent intent){
        mMediaPlayer.stop();
        mMediaPlayer.release();
        return false;
    }

    @Override
    public void onRebind(Intent intent){

    }
}
