package com.example.truongkhanh.ofmusicapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.truongkhanh.ofmusicapp.Model.ModelSQLite.Banner;
import com.example.truongkhanh.ofmusicapp.R;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    private final Context mContext;
    ArrayList<Banner> arrayListBanner;
    ImageView imageView;

    public BannerAdapter(Context context, ArrayList<Banner> banners){
        this.mContext = context;
        this.arrayListBanner = banners;
    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(R.layout.row_banner,null);

        imageView = (ImageView) view.findViewById(R.id.ImageView_row_banner);

        Glide.with(mContext).load(arrayListBanner.get(position).getLINKIMG()).into(imageView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BannerClicked", "Click In Banner Number: " + position);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
