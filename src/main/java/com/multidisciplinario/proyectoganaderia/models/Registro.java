package com.multidisciplinario.proyectoganaderia.models;

import java.util.ArrayList;

public class Registro {
    private static ArrayList<Animal> listaAnimales = new ArrayList<>();

    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }

    public boolean addAnimal(Animal animal){
        return listaAnimales.add(animal);
    }
    public boolean eliminarAnimal(Animal animal) {
        return listaAnimales.remove(animal);
    }
    public void setListaAnimales(ArrayList<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }
    public Animal buscarAnimalPorArete(int numArete) {
        for (Animal animal : listaAnimales) {
            if (animal.getNumeroArete() == numArete) {
                return animal;
            }
        }
        return null;
    }

}
