package com.serie.youtube.dagio.androidparatodos.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.serie.youtube.dagio.androidparatodos.R;
import com.serie.youtube.dagio.androidparatodos.coordinator.contentActivity;

import java.util.Timer;
import java.util.TimerTask;

public class splashActivity extends AppCompatActivity {

    private static final long SPLASH=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


     /* creando la tarea para pasar a otra actividad despues de cumplirse un ierto tiempo*/
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=null;


                    intent=new Intent(splashActivity.this,contentActivity.class);
                    startActivity(intent);
                    finish();


            }
        };   /* Definiendo el Tiempo a traves del long*/
    Timer timer = new Timer();
    timer.schedule(task,SPLASH);



        Log.d("PANTALLAS","pantalla spash");






    }


}
