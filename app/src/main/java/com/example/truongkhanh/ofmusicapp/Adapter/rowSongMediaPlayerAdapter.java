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
import com.example.truongkhanh.ofmusicapp.Model.Song;
import com.example.truongkhanh.ofmusicapp.R;
import com.example.truongkhanh.ofmusicapp.Service.MusicService;

import java.io.File;
import java.util.ArrayList;

public class rowSongMediaPlayerAdapter extends RecyclerView.Adapter<rowSongMediaPlayerAdapter.ViewHolder>{

    ArrayList<Song> songArrayList;
    Context context;
    private Intent musicIntent;
    public MusicService musicService;
    private boolean musicBound = false;

    public rowSongMediaPlayerAdapter(ArrayList<Song> songs){
        this.songArrayList = songs;
    }

    @NonNull
    @Override
    public rowSongMediaPlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.row_song_for_media, viewGroup, false);

        if(musicIntent==null){
            musicIntent = new Intent(context, MusicService.class);
            context.bindService(musicIntent,MusicConnection,context.BIND_AUTO_CREATE);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rowSongMediaPlayerAdapter.ViewHolder viewHolder, int i) {
        Song song = songArrayList.get(i);

        getImageSong(viewHolder, i);
        viewHolder.txtViewNameAuthor.setText(song.getNameAuthor());
        viewHolder.txtViewNameArtis.setText(song.getNameArtis());
        viewHolder.txtViewNameSong.setText(song.getNameSong());
    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageSong;
        TextView txtViewNameSong, txtViewNameArtis, txtViewNameAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            txtViewNameSong = itemView.findViewById(R.id.TextView_NameSong_row_song_Media);
            txtViewNameArtis = itemView.findViewById(R.id.TextView_NameArtis_row_song_Media);
            txtViewNameAuthor = itemView.findViewById(R.id.TextView_NameAuthor_row_song_Media);
            imageSong = itemView.findViewById(R.id.ImageView_row_song_Media);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                }
            });
        }
    }

    private void getImageSong(ViewHolder viewHolder, int songPosition) {
        Song song = songArrayList.get(songPosition);
        if(song.getLinkImageSong().equals("")){
            File file = new File(song.getPathSong());
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(file.getAbsolutePath());
            byte[] imageByte = mmr.getEmbeddedPicture();
            Bitmap imageSong;
            if(imageByte!=null) {
                imageSong = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
                viewHolder.imageSong.setImageBitmap(imageSong);
            } else {
                // If imagebyte is NULL we get default icon for imageSong
                Drawable drawable = context.getResources().getDrawable(R.drawable.default_icon_wedidit);
                imageSong = ((BitmapDrawable)drawable).getBitmap();
                viewHolder.imageSong.setImageBitmap(imageSong);
            }
        } else {
            Glide.with(context).load(song.getLinkImageSong()).into(viewHolder.imageSong);
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
