package com.example.truongkhanh.ofmusicapp.Fragment.Component_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truongkhanh.ofmusicapp.Adapter.TopSongAdapter;
import com.example.truongkhanh.ofmusicapp.Model.ModelSQLite.BaiHat;
import com.example.truongkhanh.ofmusicapp.Model.Song;
import com.example.truongkhanh.ofmusicapp.R;
import com.example.truongkhanh.ofmusicapp.Server.APIService;
import com.example.truongkhanh.ofmusicapp.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopSongFragment extends Fragment {

    private final static ArrayList<Song> songArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    View view;

    public TopSongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_song, container, false);

        GetData();
        Mapping();

        return view;
    }

    private void Mapping() {
        recyclerView = view.findViewById(R.id.RecyclerView_top_song);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.GetTopSong();
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatArrayList = (ArrayList<BaiHat>) response.body();
                for (BaiHat baiHat: baiHatArrayList) {
                    Song song = new Song();
                    song.setNameSong(baiHat.getNAMEBAIHAT());
                    song.setNameAuthor(baiHat.getNAMECASI());
                    song.setPathSong(baiHat.getLINKBAIHAT());
                    song.setLinkImageSong(baiHat.getLINKIMG());
                    songArrayList.add(song);
                }
                // Todo: Create Adapter and attach it to recycler view
                TopSongAdapter topSongAdapter = new TopSongAdapter(getActivity(), songArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(topSongAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

}
