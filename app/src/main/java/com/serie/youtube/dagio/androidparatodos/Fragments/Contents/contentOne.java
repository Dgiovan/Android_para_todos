package com.serie.youtube.dagio.androidparatodos.Fragments.Contents;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.serie.youtube.dagio.androidparatodos.R;

import java.io.InputStream;


public class contentOne extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

TextView apptext,varapps;

    private OnFragmentInteractionListener mListener;

    public contentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static contentOne newInstance(String param1, String param2) {
        contentOne fragment = new contentOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_content_one, container, false);

        apptext=view.findViewById(R.id.textapp);
        varapps=view.findViewById(R.id.varapps);


        String textapp="";
        String textvarapps="";
        try {
            InputStream is = getActivity().getAssets().open("aplicacion.txt");
            int size= is.available();
            byte[] buffer=new  byte[size];
            is.read(buffer);
            is.close();
            textapp=new String(buffer);
        }catch (Exception ex){
            ex.printStackTrace();
            Log.d("Texto",ex.toString());

        }
        try {
            InputStream isa= getActivity().getAssets().open("tiposapps.txt");
            int size= isa.available();
            byte[] buffer=new  byte[size];
            isa.read(buffer);
            isa.close();
            textvarapps=new String(buffer);
        } catch (Exception ex){
            ex.printStackTrace();
            Log.d("Texto tipos de apss",ex.toString());
        }
        varapps.setText(textvarapps);
        apptext.setText(textapp);
        return view;
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
