package com.example.lvimagenes_2;

public class Persona {
    private String nombre;
    private char genero;

    public Persona(String nombre, char genero) {
        this.nombre=nombre;
        this.genero=genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }
}