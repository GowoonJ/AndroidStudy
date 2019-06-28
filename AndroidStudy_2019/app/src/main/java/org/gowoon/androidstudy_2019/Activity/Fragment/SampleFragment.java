package org.gowoon.androidstudy_2019.Activity.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.gowoon.androidstudy_2019.R;

public class SampleFragment extends Fragment {


    public SampleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        // Inflate the layout for this fragment

        TextView tv_sample = view.findViewById(R.id.tv_sample);
        tv_sample.setText(getArguments().getString("key"));

        return view;
    }

}
