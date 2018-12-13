package com.serie.youtube.dagio.androidparatodos.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.serie.youtube.dagio.androidparatodos.ConexionSQLiteHelper;
import com.serie.youtube.dagio.androidparatodos.R;
import com.serie.youtube.dagio.androidparatodos.Utilidades.Utilidades;

import java.util.Timer;
import java.util.TimerTask;

public class splashActivity extends AppCompatActivity {

    private static final long SPLASH=4000;

    //Conexion base de datos
    ConexionSQLiteHelper conn;
    String tutorial="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


     /* creando la tarea para pasar a otra actividad despues de cumplirse un ierto tiempo*/
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=null;

                if (tutorial.equals("Realizado")){
                    intent=new Intent(splashActivity.this,MenuActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    intent=new Intent(splashActivity.this,contentActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };   /* Definiendo el Tiempo a traves del long*/
    Timer timer = new Timer();
    timer.schedule(task,SPLASH);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();
        String [] nombreusuario={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_GENERO};
        try {

            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,nombreusuario, String.valueOf(0),null,null,null,null);
            cursor.moveToFirst();

            tutorial=(cursor.getString(0));

            cursor.close();

        }catch (Exception e){
            Log.e("TAG","Algo esta mal con la basede datos");
        }








    }


}
