package com.serie.youtube.dagio.androidparatodos.Entidades;

public class User {
    private String nombre;
    private String genero;
    private String tutorial;

    public User(String nombre, String genero, String tutorial) {
        this.nombre = nombre;
        this.genero = genero;
        this.tutorial = tutorial;
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

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
}
