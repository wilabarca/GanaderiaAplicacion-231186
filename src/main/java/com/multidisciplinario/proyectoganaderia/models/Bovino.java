package com.multidisciplinario.proyectoganaderia.models;

public class Bovino extends Animal {
    private String raza;

    public Bovino(int numeroArete, double peso, int edad, String genero, String fecha, String vacunDectomax, String vacunGanaverm, String vacunAdbac, String vacunDerrivax, String vacunVitanegra, String vacunCatosal, String raza) {
        super(numeroArete, peso, edad, genero, fecha, vacunDectomax, vacunGanaverm, vacunAdbac, vacunDerrivax, vacunVitanegra, vacunCatosal);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
