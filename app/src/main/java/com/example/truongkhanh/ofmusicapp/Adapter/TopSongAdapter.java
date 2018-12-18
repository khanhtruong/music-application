package com.example.truongkhanh.ofmusicapp.Adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.truongkhanh.ofmusicapp.MediaPlayerActivity;
import com.example.truongkhanh.ofmusicapp.Model.Song;
import com.example.truongkhanh.ofmusicapp.R;
import com.example.truongkhanh.ofmusicapp.Service.MusicService;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class TopSongAdapter extends RecyclerView.Adapter<TopSongAdapter.ViewHolder> {

    ArrayList<Song> songArrayList;
    Context context;

    private Intent musicIntent;
    public MusicService musicService;
    private boolean musicBound = false;

    public TopSongAdapter(Context context, ArrayList<Song> songs){
        this.songArrayList = songs;
        this.context = context;
    }

    @NonNull
    @Override
    public TopSongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_song, viewGroup, false);

        if(!musicBound){
            musicIntent = new Intent(context, MusicService.class);
            context.bindService(musicIntent,MusicConnection,context.BIND_AUTO_CREATE);
            context.startService(musicIntent);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSongAdapter.ViewHolder viewHolder, int i) {
        Song song = songArrayList.get(i);
        viewHolder.nameSong.setText(song.getNameSong());
        viewHolder.nameArtis.setText("");
        viewHolder.nameAuthor.setText(song.getNameAuthor());
        Glide.with(context).load(song.getLinkImageSong()).into(viewHolder.imageViewSong);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewSong;
        TextView nameSong, nameArtis, nameAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSong = itemView.findViewById(R.id.ImageView_row_song);
            nameSong = itemView.findViewById(R.id.TextView_NameSong_row_song);
            nameArtis = itemView.findViewById(R.id.TextView_NameArtis_row_song);
            nameAuthor = itemView.findViewById(R.id.TextView_NameAuthor_row_song);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                    intent.putExtra("PlaySong", songArrayList);
                    intent.putExtra("SongPosition", Position);
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
            musicService.getData(songArrayList);
            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound = false;
        }
    };
}
