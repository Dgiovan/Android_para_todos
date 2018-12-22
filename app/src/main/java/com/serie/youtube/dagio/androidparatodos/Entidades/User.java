package com.serie.youtube.dagio.androidparatodos.Entidades;

public class User {
    private String nombre;
    private String genero;
    private String concepos;
    private String ideAn;
    private String elementos;
    private String apps;

    public User(String nombre, String genero, String concepos, String ideAn, String elementos, String apps) {
        this.nombre = nombre;
        this.genero = genero;
        this.concepos = concepos;
        this.ideAn = ideAn;
        this.elementos = elementos;
        this.apps = apps;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getConcepos() {
        return concepos;
    }

    public void setConcepos(String concepos) {
        this.concepos = concepos;
    }

    public String getIdeAn() {
        return ideAn;
    }

    public void setIdeAn(String ideAn) {
        this.ideAn = ideAn;
    }

    public String getElementos() {
        return elementos;
    }

    public void setElementos(String elementos) {
        this.elementos = elementos;
    }

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
    }
}
