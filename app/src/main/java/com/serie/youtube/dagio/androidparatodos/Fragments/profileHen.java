package com.serie.youtube.dagio.androidparatodos.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.serie.youtube.dagio.androidparatodos.Activitys.MenuActivity;
import com.serie.youtube.dagio.androidparatodos.ConexionSQLiteHelper;
import com.serie.youtube.dagio.androidparatodos.R;
import com.serie.youtube.dagio.androidparatodos.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link profileHen.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link profileHen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profileHen extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ProgressBar profile,concep,ide,element,apps;
    ImageView back;
    TextView name;
    LinearLayout contentmenu,contenthe;

    //Conexion con la base de datos
    ConexionSQLiteHelper conn;


    public profileHen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profileHen.
     */
    // TODO: Rename and change types and number of parameters
    public static profileHen newInstance(String param1, String param2) {
        profileHen fragment = new profileHen();
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

        View view= inflater.inflate(R.layout.fragment_profile_hen, container, false);

       //progress bar
        profile= view.findViewById(R.id.profile);
        concep=view.findViewById(R.id.Pbconceptos);
        ide=view.findViewById(R.id.Pbide);
        element=view.findViewById(R.id.Pbelementos);
        apps=view.findViewById(R.id.Pbaplicaciones);

        back= view.findViewById(R.id.imgback);
        contentmenu=view.findViewById(R.id.contenedormenu);
        contenthe=view.findViewById(R.id.contedorfragmenthe);

        name=view.findViewById(R.id.namehe);
        // Inflate the layout for this fragment

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(getContext(),MenuActivity.class);
               startActivity(intent);


            }
        });

        profile.setProgress(20);
        Log.d("PANTALLAS","fragment perfil hombre");


        //Consulta de la base de datos :)
        conn = new ConexionSQLiteHelper(getContext(),"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        String perfil[]={Utilidades.CAMPO_NOMBRE,
                        Utilidades.CAMPO_CONCEPTOS,
                        Utilidades.CAMPO_IDEAN,
                        Utilidades.CAMPO_ELEMENTOS,
                        Utilidades.CAMPO_APPS};
        try {
            Cursor cursor= db.query(Utilidades.TABLA_USUARIO,perfil,String.valueOf(1),null,null,null,null);
            cursor.moveToFirst();

            name.setText(cursor.getString(0));
            concep.setProgress(Integer.parseInt(cursor.getString(1)));
            ide.setProgress(Integer.parseInt(cursor.getString(2)));
            element.setProgress(Integer.parseInt(cursor.getString(3)));
            apps.setProgress(Integer.parseInt(cursor.getString(4)));

        }catch (Exception e){
            Log.e("TAG","LA consuta para perfil fallo");
        }
        return view;
        // Inflate the layout for this fragmen
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
