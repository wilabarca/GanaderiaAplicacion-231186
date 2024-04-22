package com.multidisciplinario.proyectoganaderia.controllers;

import com.multidisciplinario.proyectoganaderia.App;
import com.multidisciplinario.proyectoganaderia.models.Animal;
import com.multidisciplinario.proyectoganaderia.models.Registro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificarController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AdbacText;

    @FXML
    private Button BotonModificar;

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
    private TextField txtFechaModificacion;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtNumArete;

    @FXML
    private TextField txtPeso;

    private Registro registro;

    @FXML
    private Button BotonBuscar;

    @FXML
    void onMouseClickedBotonBuscar(MouseEvent event) {
        String numArete = txtNumArete.getText();
        if (!numArete.isEmpty()) {
            int numAreteInt = Integer.parseInt(numArete);
            Animal animal = registro.buscarAnimalPorArete(numAreteInt);
            if (animal != null) {
                txtEdad.setText(String.valueOf(animal.getEdad()));
                txtGenero.setText(animal.getGenero());
                txtPeso.setText(String.valueOf(animal.getPeso()));
                txtFechaModificacion.setText(animal.getFecha());
                DectomaxText.setText(animal.getVacunDectomax());
                GanavermText.setText(animal.getVacunGanaverm());
                AdbacText.setText(animal.getVacunAdbac());
                DerrivaxText.setText(animal.getVacunDerrivax());
                VitanegraText.setText(animal.getVacunVitanegra());
                CatosalText.setText(animal.getVacunCatosal());
            } else {
                mostrarAlerta("Animal no encontrado", "No se encontró ningún animal con el número de arete proporcionado.");
            }
        } else {
            mostrarAlerta("Campo vacío", "Por favor, ingrese un número de arete antes de buscar.");
        }
    }

    @FXML
    void onMouseClickedBotonModificar(MouseEvent event) {
        String numArete = txtNumArete.getText();
        if (!numArete.isEmpty()) {
            int numAreteInt = Integer.parseInt(numArete);
            Animal animal = registro.buscarAnimalPorArete(numAreteInt);
            if (animal != null) {
                actualizarDatosAnimal(animal);
                mostrarAlerta("Éxito", "Los datos del animal se han modificado correctamente.");
            } else {
                mostrarAlerta("Animal no encontrado", "No se encontró ningún animal con el número de arete proporcionado.");
            }
        } else {
            mostrarAlerta("Campo vacío", "Por favor, ingrese un número de arete antes de buscar.");
        }
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

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    private void cerrarVentana() {
        Stage stageActual = (Stage) BotonRegresar.getScene().getWindow();
        stageActual.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void actualizarDatosAnimal(Animal animal) {
        animal.setEdad(Integer.parseInt(txtEdad.getText()));
        animal.setGenero(txtGenero.getText());
        animal.setPeso(Double.parseDouble(txtPeso.getText()));
        animal.setFecha(txtFechaModificacion.getText());
        animal.setVacunDectomax(DectomaxText.getText());
        animal.setVacunGanaverm(GanavermText.getText());
        animal.setVacunAdbac(AdbacText.getText());
        animal.setVacunDerrivax(DerrivaxText.getText());
        animal.setVacunVitanegra(VitanegraText.getText());
        animal.setVacunCatosal(CatosalText.getText());
        registro.setListaAnimales(registro.getListaAnimales());
    }

}
