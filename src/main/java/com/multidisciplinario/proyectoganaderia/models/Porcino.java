package com.multidisciplinario.proyectoganaderia.models;

public class Porcino extends Animal {
    private String tipoDeAlimento;

    public Porcino(int numeroArete, double peso, int edad, String genero, String fecha, String vacunDectomax, String vacunGanaverm, String vacunAdbac, String vacunDerrivax, String vacunVitanegra, String vacunCatosal, String tipoDeAlimento) {
        super(numeroArete, peso, edad, genero, fecha, vacunDectomax, vacunGanaverm, vacunAdbac, vacunDerrivax, vacunVitanegra, vacunCatosal);
        this.tipoDeAlimento = tipoDeAlimento;
    }

    public String getTipoDeAlimento() {
        return tipoDeAlimento;
    }

    public void setTipoDeAlimento(String tipoDeAlimento) {
        this.tipoDeAlimento = tipoDeAlimento;
    }
}
