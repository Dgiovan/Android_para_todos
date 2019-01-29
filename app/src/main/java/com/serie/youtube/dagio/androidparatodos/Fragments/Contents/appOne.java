package com.serie.youtube.dagio.androidparatodos.Fragments.Contents;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.serie.youtube.dagio.androidparatodos.R;


public class appOne extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView login;

    private OnFragmentInteractionListener mListener;

    public appOne() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static appOne newInstance(String param1, String param2) {
        appOne fragment = new appOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_app_one, container, false);
        login= v.findViewById(R.id.Imlogin);

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final Dialog LOGIN= new Dialog(getContext());
               final LinearLayout mylogin;
               LOGIN.setContentView(R.layout.optionlogin);
               LOGIN.show();
               mylogin=LOGIN.findViewById(R.id.LayoutLogin);
               mylogin.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       final Button text;
                       text=LOGIN.findViewById(R.id.mytest);
                       text.setOnClickListener(this);

                       switch (v.getId())
                       {
                           case R.id.mytest:
                               Toast.makeText(getContext(), "Exito", Toast.LENGTH_SHORT).show();
                               break;
                       }

                   }
               });
           }
       });


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
