package com.multidisciplinario.proyectoganaderia.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Animal {
    private SimpleIntegerProperty numeroArete;
    private SimpleDoubleProperty peso;
    private SimpleIntegerProperty edad;
    private SimpleStringProperty genero;
    private SimpleStringProperty fecha;
    private SimpleStringProperty vacunDectomax;
    private SimpleStringProperty vacunGanaverm;
    private SimpleStringProperty vacunAdbac;
    private SimpleStringProperty vacunDerrivax;
    private SimpleStringProperty vacunVitanegra;
    private SimpleStringProperty vacunCatosal;

    public Animal(int numeroArete, double peso, int edad, String genero, String fecha, String vacunDectomax, String vacunGanaverm, String vacunAdbac, String vacunDerrivax, String vacunVitanegra, String vacunCatosal) {
        this.numeroArete = new SimpleIntegerProperty(numeroArete);
        this.peso = new SimpleDoubleProperty(peso);
        this.edad = new SimpleIntegerProperty(edad);
        this.genero = new SimpleStringProperty(genero);
        this.fecha = new SimpleStringProperty(fecha);
        this.vacunDectomax = new SimpleStringProperty(vacunDectomax);
        this.vacunGanaverm = new SimpleStringProperty(vacunGanaverm);
        this.vacunAdbac = new SimpleStringProperty(vacunAdbac);
        this.vacunDerrivax = new SimpleStringProperty(vacunDerrivax);
        this.vacunVitanegra = new SimpleStringProperty(vacunVitanegra);
        this.vacunCatosal = new SimpleStringProperty(vacunCatosal);
    }
    public int getNumeroArete() {
        return numeroArete.get();
    }

    public SimpleIntegerProperty numeroAreteProperty() {
        return numeroArete;
    }

    public void setNumeroArete(int numeroArete) {
        this.numeroArete.set(numeroArete);
    }

    public double getPeso() {
        return peso.get();
    }

    public SimpleDoubleProperty pesoProperty() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso.set(peso);
    }

    public int getEdad() {
        return edad.get();
    }

    public SimpleIntegerProperty edadProperty() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad.set(edad);
    }
    public String getGenero() {
        return genero.get();
    }

    public SimpleStringProperty generoProperty() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero.set(genero);
    }

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getVacunDectomax() {
        return vacunDectomax.get();
    }

    public SimpleStringProperty vacunDectomaxProperty() {
        return vacunDectomax;
    }

    public void setVacunDectomax(String vacunDectomax) {
        this.vacunDectomax.set(vacunDectomax);
    }

    public String getVacunGanaverm() {
        return vacunGanaverm.get();
    }

    public SimpleStringProperty vacunGanavermProperty() {
        return vacunGanaverm;
    }

    public void setVacunGanaverm(String vacunGanaverm) {
        this.vacunGanaverm.set(vacunGanaverm);
    }

    public String getVacunAdbac() {
        return vacunAdbac.get();
    }

    public SimpleStringProperty vacunAdbacProperty() {
        return vacunAdbac;
    }

    public void setVacunAdbac(String vacunAdbac) {
        this.vacunAdbac.set(vacunAdbac);
    }

    public String getVacunDerrivax() {
        return vacunDerrivax.get();
    }

    public SimpleStringProperty vacunDerrivaxProperty() {
        return vacunDerrivax;
    }

    public void setVacunDerrivax(String vacunDerrivax) {
        this.vacunDerrivax.set(vacunDerrivax);
    }

    public String getVacunVitanegra() {
        return vacunVitanegra.get();
    }

    public SimpleStringProperty vacunVitanegraProperty() {
        return vacunVitanegra;
    }

    public void setVacunVitanegra(String vacunVitanegra) {
        this.vacunVitanegra.set(vacunVitanegra);
    }

    public String getVacunCatosal() {
        return vacunCatosal.get();
    }

    public SimpleStringProperty vacunCatosalProperty() {
        return vacunCatosal;
    }

    public void setVacunCatosal(String vacunCatosal) {
        this.vacunCatosal.set(vacunCatosal);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "numeroArete=" + numeroArete +
                ", peso=" + peso +
                ", edad=" + edad +
                ", genero=" + genero +
                ", fecha=" + fecha +
                ", vacunDectomax=" + vacunDectomax +
                ", vacunGanaverm=" + vacunGanaverm +
                ", vacunAdbac=" + vacunAdbac +
                ", vacunDerrivax=" + vacunDerrivax +
                ", vacunVitanegra=" + vacunVitanegra +
                ", vacunCatosal=" + vacunCatosal ;
    }
}
