package com.serie.youtube.dagio.androidparatodos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
                Intent intent=new Intent(splashActivity.this,contentActivity.class);
                startActivity(intent);
                finish();
            }
        };   /* Definiendo el Tiempo a traves del long*/
    Timer timer = new Timer();
    timer.schedule(task,SPLASH);



    }


}
