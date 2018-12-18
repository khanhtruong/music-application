package com.example.truongkhanh.ofmusicapp.Fragment.Component_Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truongkhanh.ofmusicapp.Adapter.BannerAdapter;
import com.example.truongkhanh.ofmusicapp.Model.ModelSQLite.Banner;
import com.example.truongkhanh.ofmusicapp.R;
import com.example.truongkhanh.ofmusicapp.Server.APIService;
import com.example.truongkhanh.ofmusicapp.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListBannerFragment extends Fragment {

    View view;
    CircleIndicator circleIndicator;
    ViewPager viewPager;
    BannerAdapter bannerAdapter;

    public ListBannerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_banner, container, false);

        getData();
        Mapping();

        return view;
    }

    private void Mapping() {
        viewPager = view.findViewById(R.id.ViewPager_List_Banner);
        circleIndicator = view.findViewById(R.id.CircleIndicator_List_Banner);
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Banner>> callback = dataservice.GetAllBanner();
        callback.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                ArrayList<Banner> arrayListBanner = (ArrayList<Banner>) response.body();

                bannerAdapter = new BannerAdapter(getActivity(), arrayListBanner);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {

            }
        });
    }

}
