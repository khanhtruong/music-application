package com.example.truongkhanh.ofmusicapp.Adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.truongkhanh.ofmusicapp.Activity.MediaPlayerActivity;
import com.example.truongkhanh.ofmusicapp.Model.Song;
import com.example.truongkhanh.ofmusicapp.R;
import com.example.truongkhanh.ofmusicapp.Service.MusicService;

import java.io.File;
import java.util.ArrayList;

public class TopAllSongAdapter extends RecyclerView.Adapter<TopAllSongAdapter.ViewHolder> {
    ArrayList<Song> arrayListSong;
    private Context context;
    private Intent musicIntent;
    public MusicService musicService;
    private boolean musicBound = false;

    public TopAllSongAdapter(ArrayList<Song> songs){
        this.arrayListSong = songs;
    }

    @NonNull
    @Override
    public TopAllSongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_song,viewGroup,false);

        if(!musicBound){
            musicIntent = new Intent(context, MusicService.class);
            context.bindService(musicIntent,MusicConnection,context.BIND_AUTO_CREATE);
//            context.startService(musicIntent);
        }

        // Return ViewHolder from view create above
        return new TopAllSongAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopAllSongAdapter.ViewHolder viewHolder, int i) {
        Song song = arrayListSong.get(i);
        viewHolder.nameSong.setText(song.getNameSong());
        viewHolder.nameArtis.setText(song.getNameArtis());
        viewHolder.nameAuthor.setText(song.getNameAuthor());

        // Get Image from File MP3
        Glide.with(context).load(song.getLinkImageSong()).into(viewHolder.imageViewSong);
    }

    @Override
    public int getItemCount() {
        return arrayListSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewSong;
        TextView nameSong, nameArtis, nameAuthor;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageViewSong = itemView.findViewById(R.id.ImageView_row_song);
            nameSong = itemView.findViewById(R.id.TextView_NameSong_row_song);
            nameArtis = itemView.findViewById(R.id.TextView_NameArtis_row_song);
            nameAuthor = itemView.findViewById(R.id.TextView_NameAuthor_row_song);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create Service
                    musicService.getData(arrayListSong);

                    // Call Intent and pop to new Activity MediaPlayerActivity
                    int Position = getPosition();
                    if(musicService.getmRandom()) {
                        musicService.setmRandom(false);
                        musicService.setSong(Position);
                        musicService.PlaySong();
                        musicService.setmRandom(true);
                    } else {
                        musicService.setSong(Position);
                        musicService.PlaySong();
                    }

                    Context context = v.getContext();
                    Intent intent = new Intent(context, MediaPlayerActivity.class);
                    intent.putExtra("PlaySong", arrayListSong);
                    intent.putExtra("SongPosition", Position);
                    intent.putExtra("OnlineSong", true);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public ServiceConnection MusicConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder)service;
            // Get service
            musicService = binder.getService();
            // Send Data
            musicService.getData(arrayListSong);
            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound = false;
        }
    };
}
