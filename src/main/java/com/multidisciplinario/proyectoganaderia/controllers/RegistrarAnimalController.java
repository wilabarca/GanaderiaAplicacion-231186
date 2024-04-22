package com.multidisciplinario.proyectoganaderia.controllers;

import com.multidisciplinario.proyectoganaderia.App;
import com.multidisciplinario.proyectoganaderia.models.Animal;
import com.multidisciplinario.proyectoganaderia.models.Bovino;
import com.multidisciplinario.proyectoganaderia.models.Porcino;
import com.multidisciplinario.proyectoganaderia.models.Registro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarAnimalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AdbacText;

    @FXML
    private Button BotonRegistrar;

    @FXML
    private Button BotonRegresar;

    @FXML
    private TextField CatosalText;

    @FXML
    private TextField DectomaxText;

    @FXML
    private TextField DerrivaxText;

    @FXML
    private TextField GanavermText;

    @FXML
    private TextField VitanegraText;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNumArete;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtFecha;

    private Registro registro = new Registro();

    @FXML
    void onMouseClickedRegistraButton(MouseEvent event) {
        int numeroArete = Integer.parseInt(txtNumArete.getText());
        double peso = Double.parseDouble(txtPeso.getText());
        int edad = Integer.parseInt(txtEdad.getText());
        String genero = txtGenero.getText();
        String fecha = txtFecha.getText();
        String vacunDectomax = DectomaxText.getText();
        String vacunGanaverm = GanavermText.getText();
        String vacunAdbac = AdbacText.getText();
        String vacunDerrivax = DerrivaxText.getText();
        String vacunVitanegra = VitanegraText.getText();
        String vacunCatosal = CatosalText.getText();
        String raza = "";

        Animal nuevoAnimal;
        if (raza.equalsIgnoreCase("Holstein") || raza.equalsIgnoreCase("Angus") || raza.equalsIgnoreCase("Hereford")) {
            nuevoAnimal = new Bovino(numeroArete, peso, edad, genero, fecha, vacunDectomax, vacunGanaverm, vacunAdbac, vacunDerrivax, vacunVitanegra, vacunCatosal, raza);
        } else {
            String tipoDeAlimento = "";
            nuevoAnimal = new Porcino(numeroArete, peso, edad, genero, fecha, vacunDectomax, vacunGanaverm, vacunAdbac, vacunDerrivax, vacunVitanegra, vacunCatosal, tipoDeAlimento);
        }

        registro.addAnimal(nuevoAnimal);
        System.out.println("Nuevo animal registrado:");
        System.out.println("Número de Arete: " + nuevoAnimal.getNumeroArete());
        System.out.println("Peso: " + nuevoAnimal.getPeso());
        System.out.println("Edad: " + nuevoAnimal.getEdad());
        System.out.println("Género: " + nuevoAnimal.getGenero());
        System.out.println("Fecha: " + nuevoAnimal.getFecha());
        System.out.println("VacunDectomax: " + nuevoAnimal.getVacunDectomax());
        System.out.println("VacunGanaverm: " + nuevoAnimal.getVacunGanaverm());
        System.out.println("VacunAdbac: " + nuevoAnimal.getVacunAdbac());
        System.out.println("VacunDerrivax: " + nuevoAnimal.getVacunDerrivax());
        System.out.println("VacunVitanegra: " + nuevoAnimal.getVacunVitanegra());
        System.out.println("VacunCatosal: " + nuevoAnimal.getVacunCatosal());
        limpiarCamposTexto();
    }



    @FXML
    void onMouseClickedRegresarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void initialize() {

    }

    private void cerrarVentana() {
        Stage stageActual = (Stage) BotonRegresar.getScene().getWindow();
        stageActual.close();
    }

    private void limpiarCamposTexto() {
        txtNumArete.clear();
        txtPeso.clear();
        txtNumArete.clear();
        txtEdad.clear();
        txtGenero.clear();
        DectomaxText.clear();
        GanavermText.clear();
        AdbacText.clear();
        DerrivaxText.clear();
        VitanegraText.clear();
        CatosalText.clear();
    }

}
