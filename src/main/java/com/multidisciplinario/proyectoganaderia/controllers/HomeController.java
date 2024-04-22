package com.multidisciplinario.proyectoganaderia.controllers;

import com.multidisciplinario.proyectoganaderia.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EliminarGanado;

    @FXML
    private Button RegistraGanado;

    @FXML
    private Button VerGanado;

    @FXML
    private Button VerReporte;

    @FXML
    private Button SalirButton;

    @FXML
    void onMouseClickedEliminarGanado(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("EliminarGanado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void onMouseClickedRegistrarGanado(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("RegistrarGanado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void onMouseClickedVerGanado(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VerGanado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void onMouseClieckedVerReporte(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VerReporte.fxml"));
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

    @FXML
    void onMouseClickedSalirButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("IniciodeSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stageActual = (Stage) SalirButton.getScene().getWindow();
        stageActual.close();
    }

}
