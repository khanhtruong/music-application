package com.example.truongkhanh.ofmusicapp.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.truongkhanh.ofmusicapp.Fragment.TabLayout_Fragment.HomeFragment;
import com.example.truongkhanh.ofmusicapp.Fragment.TabLayout_Fragment.PersonFragment;
import com.example.truongkhanh.ofmusicapp.R;

public class TabLayoutMainPageAdapter extends FragmentPagerAdapter {

    Context mContext;

    public TabLayoutMainPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PersonFragment();
            case 1:
                return new HomeFragment();
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return mContext.getString(R.string.menu_personal);
            case 1:
                return mContext.getString(R.string.menu_home);
            default :
                return null;
        }
    }
}
