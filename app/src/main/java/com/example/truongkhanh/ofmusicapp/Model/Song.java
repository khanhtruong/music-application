package com.example.truongkhanh.ofmusicapp.Model;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.Serializable;

public class Song implements Parcelable {

    @SerializedName("NameSong")
    @Expose
    private String nameSong;
    @SerializedName("LinkImageSong")
    @Expose
    private String linkImageSong;
    @SerializedName("NameArtis")
    @Expose
    private String nameArtis;
    @SerializedName("NameAlbum")
    @Expose
    private String nameAlbum;
    @SerializedName("NameAuthor")
    @Expose
    private String nameAuthor;
    @SerializedName("PathSong")
    @Expose
    private String pathSong;


    public Song(){ }

    protected Song(Parcel in) {
        nameSong = in.readString();
        linkImageSong = in.readString();
        nameArtis = in.readString();
        nameAlbum = in.readString();
        nameAuthor = in.readString();
        pathSong = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };


    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getLinkImageSong() {
        return linkImageSong;
    }

    public void setLinkImageSong(String linkImageSong) {
        this.linkImageSong = linkImageSong;
    }

    public String getNameArtis() {
        return nameArtis;
    }

    public void setNameArtis(String nameArtis) {
        this.nameArtis = nameArtis;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getPathSong() { return pathSong; }

    public void setPathSong(String pathSong) { this.pathSong = pathSong; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameSong);
        dest.writeString(linkImageSong);
        dest.writeString(nameArtis);
        dest.writeString(nameAlbum);
        dest.writeString(nameAuthor);
        dest.writeString(pathSong);
    }
}