package com.example.truongkhanh.ofmusicapp.Fragment.TabLayout_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truongkhanh.ofmusicapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    View view;

    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_person, container, false);
        return view;
    }

}
