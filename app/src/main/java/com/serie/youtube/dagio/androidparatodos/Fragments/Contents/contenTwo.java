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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contenTwo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contenTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contenTwo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView activitytext,intenttext,broadcasttext,fragmenttext;


    private OnFragmentInteractionListener mListener;

    public contenTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contenTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static contenTwo newInstance(String param1, String param2) {
        contenTwo fragment = new contenTwo();
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
        View view=inflater.inflate(R.layout.fragment_conten_two, container, false);
        activitytext=view.findViewById(R.id.textActivity);
        intenttext= view.findViewById(R.id.Intenttext);
        broadcasttext= view.findViewById(R.id.broadcastext);
        fragmenttext= view.findViewById(R.id.fragmenttext);


        String setTextaap= null;
        String setTextaap1 = null;
        String setTextapp2= null;
        String setTextapp3=null;



        try {
            InputStream is = getActivity().getAssets().open("Activitytext.txt");
            int size= is.available();
            byte[] buffer=new  byte[size];
            is.read(buffer);
            is.close();
            setTextaap=new String(buffer);
        }catch (Exception ex){
            ex.printStackTrace();
            Log.d("Texto",ex.toString());

        }
        try {
            InputStream is =getActivity().getAssets().open("IntentText.txt");
            int size=is.available();
            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();
            setTextaap1=new String(buffer);

        }catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d("Texto",ex.toString());
        }
        try {
            InputStream is =getActivity().getAssets().open("BroadcastReceiverText.txt");
            int size=is.available();
            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();
            setTextapp2=new String(buffer);

        }catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d("Texto",ex.toString());
        }
        try {
            InputStream is =getActivity().getAssets().open("FragmentText.txt");
            int size=is.available();
            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();
            setTextapp3=new String(buffer);

        }catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d("Texto",ex.toString());
        }
        fragmenttext.setText(setTextapp3);
        broadcasttext.setText(setTextapp2);
        intenttext.setText(setTextaap1);
        activitytext.setText(setTextaap);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
