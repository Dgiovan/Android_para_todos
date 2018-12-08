package com.serie.youtube.dagio.androidparatodos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.serie.youtube.dagio.androidparatodos.Utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {




    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
     //crea Tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);

    }
    //actualiza tablas
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);

    }
}
