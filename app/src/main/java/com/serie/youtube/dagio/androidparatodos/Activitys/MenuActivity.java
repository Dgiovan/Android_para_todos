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
import com.serie.youtube.dagio.androidparatodos.Fragments.registryFragment;
import com.serie.youtube.dagio.androidparatodos.R;
import com.serie.youtube.dagio.androidparatodos.Utilidades.Utilidades;

import java.util.ArrayList;


public class MenuActivity extends AppCompatActivity implements profileHen.OnFragmentInteractionListener,profileShen.OnFragmentInteractionListener {

    //Elementos graficos
    TextView name;
    LinearLayout perfil;
    LinearLayout contentmenu,contenthe,contentshe;

    //Boon Menu
    private BoomMenuButton bmb;
    ArrayList<Integer> imageIDList;

    //Conexion base de datos
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bmb=findViewById(R.id.bmb);
        name =findViewById(R.id.nameprofile);
        perfil=findViewById(R.id.Lprofile);
        contentmenu=findViewById(R.id.contenedormenu);
        contenthe=findViewById(R.id.contedorfragmenthe);
        contentshe=findViewById(R.id.contedorfragmentshe);

        //iniciadores de vista
        contenthe.setVisibility(View.GONE);
        contentmenu.setVisibility(View.VISIBLE);
        contentshe.setVisibility(View.GONE);

        //escuchadores
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contenthe.setVisibility(View.VISIBLE);
                contentmenu.setVisibility(View.GONE);
                contentshe.setVisibility(View.GONE);


            }
        });


        imageIDList=new ArrayList<>();
        setInitialData();

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();
        String [] nombreusuario={Utilidades.CAMPO_NOMBRE};
        try {

            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,nombreusuario, String.valueOf(1),null,null,null,null);
            cursor.moveToFirst();
            name.setText(cursor.getString(0));
            cursor.close();

        }catch (Exception e){
            Log.e("TAG","Algo esta mal con la basede datos");
        }



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

    }

    private void setInitialData() {
        imageIDList.add(R.drawable.xml);
        imageIDList.add(R.drawable.java);
        imageIDList.add(R.drawable.gradlelogo);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
