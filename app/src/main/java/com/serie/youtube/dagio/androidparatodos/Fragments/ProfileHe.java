package com.serie.youtube.dagio.androidparatodos.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.serie.youtube.dagio.androidparatodos.Activitys.MenuActivity;
import com.serie.youtube.dagio.androidparatodos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileHe extends Fragment {
ProgressBar profile;
ImageView back;

    public ProfileHe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile_he, container, false);
        profile= view.findViewById(R.id.profile);
        back= view.findViewById(R.id.imgback);
        // Inflate the layout for this fragment

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(),MenuActivity.class);
                startActivity(intent);
            }
        });

        profile.setProgress(20);

        return view;
    }

}
