package com.example.truongkhanh.ofmusicapp.Server;

import com.example.truongkhanh.ofmusicapp.Model.ModelSQLite.BaiHat;

import com.example.truongkhanh.ofmusicapp.Model.ModelSQLite.Banner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("getAllBanner.php")
    Call<List<Banner>> GetAllBanner();

    @GET("getTopBaiHat.php")
    Call<List<BaiHat>> GetTopSong();
}
