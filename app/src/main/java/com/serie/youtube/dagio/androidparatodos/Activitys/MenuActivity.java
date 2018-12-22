package com.serie.youtube.dagio.androidparatodos.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.serie.youtube.dagio.androidparatodos.ConexionSQLiteHelper;
import com.serie.youtube.dagio.androidparatodos.Fragments.profileHen;
import com.serie.youtube.dagio.androidparatodos.Fragments.profileShen;
import com.serie.youtube.dagio.androidparatodos.R;
import com.serie.youtube.dagio.androidparatodos.Utilidades.Utilidades;

import java.util.ArrayList;


public class MenuActivity extends AppCompatActivity implements profileHen.OnFragmentInteractionListener,profileShen.OnFragmentInteractionListener, View.OnClickListener {

    //Elementos graficos
    TextView name;
    LinearLayout perfil,conceptos,ide,cgraficos,apps,librerias,tips;
    ImageView she,he;
    LinearLayout contentmenu,contenthe,contentshe;

    //Boon Menu
    private BoomMenuButton bmb;
    ArrayList<Integer> imageIDList;

    //Conexion base de datos
    ConexionSQLiteHelper conn;
    String genero="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Elementos
        bmb=findViewById(R.id.bmb);
        name =findViewById(R.id.nameprofile);
        he=findViewById(R.id.imgprofileboy);
        she=findViewById(R.id.imgprofiegirl);

        //Layouts Targets
        perfil= findViewById(R.id.Lprofile);
        conceptos= findViewById(R.id.Lconcept);
        ide= findViewById(R.id.Lide);
        cgraficos= findViewById(R.id.Lgraphics);
        apps= findViewById(R.id.Lapps);
        librerias= findViewById(R.id.Lboockstore);
        tips= findViewById(R.id.Lpersonalitation);

        //Visibilidades
        contentmenu=findViewById(R.id.contenedormenu);
        contenthe=findViewById(R.id.contedorfragmenthe);
        contentshe=findViewById(R.id.contedorfragmentshe);

        //iniciadores de vista
        contenthe.setVisibility(View.GONE);
        contentmenu.setVisibility(View.VISIBLE);
        contentshe.setVisibility(View.GONE);

        //onclicks
        perfil.setOnClickListener(this);
        conceptos.setOnClickListener(this);
        ide.setOnClickListener(this);
        cgraficos.setOnClickListener(this);
        apps.setOnClickListener(this);
        librerias.setOnClickListener(this);
        tips.setOnClickListener(this);


        //inicializacion parametros boom menu
        imageIDList=new ArrayList<>();
        setInitialData();

        //metodo para boom menu

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder()
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            if (index==0){
                                Toast.makeText(MenuActivity.this, "presinaste el cero " , Toast.LENGTH_SHORT).show();
                            }else if(index==1){
                                Toast.makeText(MenuActivity.this, "presinaste el 1 " , Toast.LENGTH_SHORT).show();

                            }else if (index==2){
                                Toast.makeText(MenuActivity.this, "presinaste el 2 " , Toast.LENGTH_SHORT).show();

                            }

                        }
                    })
                    .pieceColor(Color.WHITE)
                    .normalImageRes(imageIDList.get(i));

            bmb.addBuilder(builder);

        }





        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();
        String [] nombreusuario={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_GENERO};
        try {

            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,nombreusuario, String.valueOf(1),null,null,null,null);
            cursor.moveToFirst();
            name.setText(cursor.getString(0));
            genero=(cursor.getString(1));

            cursor.close();
             Log.i("TAG","Consulta de datos exitosa los datos son:"+name+genero);
        }catch (Exception e){
            Log.e("TAG","Algo esta mal con la basede datos");
        }


        if (genero.equals("boy")){
            he.setVisibility(View.VISIBLE);
            she.setVisibility(View.GONE);
        }else if (genero.equals("girl")){
            he.setVisibility(View.GONE);
            she.setVisibility(View.VISIBLE);
        }
     Log.d("PANTALLAS","pantalla menu");
    }

    private void setInitialData() {
        imageIDList.add(R.drawable.xml);
        imageIDList.add(R.drawable.java);
        imageIDList.add(R.drawable.gradlelogo);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId())
        {
            case R.id.Lprofile:
                switch (he.getVisibility()){
                    case View.VISIBLE:
                        contenthe.setVisibility(View.VISIBLE);
                        contentmenu.setVisibility(View.GONE);
                        contentshe.setVisibility(View.GONE);
                        break;
                    case View.GONE:
                        contenthe.setVisibility(View.GONE);
                        contentmenu.setVisibility(View.GONE);
                        contentshe.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.Lconcept:
                Toast.makeText(this, "conceptos", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.Lide:
                Toast.makeText(this, "ide", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.Lgraphics:
                Toast.makeText(this, "elementos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Lapps:
                Toast.makeText(this, "apps", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Lboockstore:
                Toast.makeText(this, "Librerias", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Lpersonalitation:
                Toast.makeText(this, "tips", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
