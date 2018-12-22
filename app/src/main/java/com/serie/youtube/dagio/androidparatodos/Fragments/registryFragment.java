package com.serie.youtube.dagio.androidparatodos.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.nightonke.boommenu.BoomMenuButton;
import com.serie.youtube.dagio.androidparatodos.Activitys.MenuActivity;
import com.serie.youtube.dagio.androidparatodos.ConexionSQLiteHelper;
import com.serie.youtube.dagio.androidparatodos.R;
import com.serie.youtube.dagio.androidparatodos.Utilidades.Utilidades;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link registryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link registryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class registryFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView XMl,JAVA,GRADLE;
    EditText textname;
    Button   btnListo;
    RadioButton he,she;
    public static String genere;
    public static String completado;





    private OnFragmentInteractionListener mListener;

    public registryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment registryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static registryFragment newInstance(String param1, String param2) {
        registryFragment fragment = new registryFragment();
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
         View view = inflater.inflate(R.layout.fragment_registry, container, false);


        XMl= view.findViewById(R.id.iconXml);
        JAVA= view.findViewById(R.id.iconJava);
        GRADLE=view.findViewById(R.id.iconGradle);
        textname=view.findViewById(R.id.editname);
        he=view.findViewById(R.id.Rhe);
        she=view.findViewById(R.id.Rshe);
        btnListo=view.findViewById(R.id.btnListo);





        XMl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialStyledDialog.Builder(getContext())
                        .setTitle(R.string.Titlesxml)
                        .withDialogAnimation(true)
                        .setDescription(R.string.Dialogintroxml)
                        .setHeaderDrawable(R.drawable.baackgroudialogs)
                        .setScrollable(true,18)
                        .setPositiveText(R.string.onPositivetext)
                        .show();

            }
        });
        JAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialStyledDialog.Builder(getContext())
                        .setTitle(R.string.Titlesjava)
                        .withDialogAnimation(true)
                        .setDescription(R.string.Dialogintrojava)
                        .setScrollable(true,18)
                        .setHeaderDrawable(R.drawable.baackgroudialogs)
                        .setPositiveText(R.string.onPositivetext)
                        .show();

            }
        });
        GRADLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialStyledDialog.Builder(getContext())
                        .setTitle(R.string.Titlesgradle)
                        .withDialogAnimation(true)
                        .setDescription(R.string.Dialogintrogradle)
                        .setScrollable(true,18)
                        .setHeaderDrawable(R.drawable.baackgroudialogs)
                        .setPositiveText(R.string.onPositivetext)
                        .show();

            }
        });
        
        btnListo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (textname.getText().toString().equals("")) {
                    Toast.makeText(getContext(), R.string.toast_intro_btn, Toast.LENGTH_SHORT).show();
                    Log.d("TAG","el usuario no ingreso su nombre");
                }else if((he.isChecked()||she.isChecked())!=true)
                {
                      Toast.makeText(getContext(),"Por favor selecciona tu genero",Toast.LENGTH_SHORT).show();
                    Log.d("TAG","el usuario no ingreso su genero");
                }
                else {
                     completado="Realizado";
                    if (he.isChecked()==true){
                        genere="boy";
                    }else if(she.isChecked()==true){
                        genere="girl";
                    }
                    registrarusuario();
                    Log.d("TAG","el usuario esta siendo registrado");
                    Intent intent = new Intent(getContext(), MenuActivity.class);
                    startActivity(intent);

                }
            }
        });
        Log.d("PANTALLAS","fragment Registro");
        return view;
    }

    private void registrarusuario() {
        //creando conexion con la base de datos
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(getContext(),"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,textname.getText().toString());
        values.put(Utilidades.CAMPO_GENERO,genere);
        values.put(Utilidades.CAMPO_CONCEPTOS,"0");
        values.put(Utilidades.CAMPO_IDEAN,"0");
        values.put(Utilidades.CAMPO_ELEMENTOS,"0");
        values.put(Utilidades.CAMPO_APPS,"0");

        Long nameResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_NOMBRE,values);
        Toast.makeText(getContext(), "Bienvenido "+textname.getText().toString(), Toast.LENGTH_SHORT).show();
        Log.d("TAG","usuario registrado en la base de datos");
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
