package com.multidisciplinario.proyectoganaderia.controllers;

import com.multidisciplinario.proyectoganaderia.App;
import com.multidisciplinario.proyectoganaderia.models.Animal;
import com.multidisciplinario.proyectoganaderia.models.Registro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VerReporteController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Animal, String> Fechavacunacion;

    @FXML
    private TableColumn<Animal, Integer> colArete;

    @FXML
    private TableColumn<Animal, Integer> colEdad;

    @FXML
    private TableColumn<Animal, Double> colPeso;

    @FXML
    private TableColumn<Animal, String> colVacunas;

    @FXML
    private TableColumn<Animal, String> colgenero;

    @FXML
    private Button regresar3;

    @FXML
    private TableView<Animal> tablaRegistro;

    private Registro registro;

    @FXML
    void regresar(ActionEvent event) throws IOException {
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
        registro = new Registro();
        ArrayList<Animal> listaAnimales = registro.getListaAnimales();
        ObservableList<Animal> observableListaAnimales = FXCollections.observableArrayList(listaAnimales);
        colArete.setCellValueFactory(cellData -> cellData.getValue().numeroAreteProperty().asObject());
        colEdad.setCellValueFactory(cellData -> cellData.getValue().edadProperty().asObject());
        colPeso.setCellValueFactory(cellData -> cellData.getValue().pesoProperty().asObject());
        colVacunas.setCellValueFactory(cellData -> cellData.getValue().vacunDectomaxProperty().concat(", ")
                .concat(cellData.getValue().vacunGanavermProperty()).concat(", ")
                .concat(cellData.getValue().vacunAdbacProperty()).concat(", ")
                .concat(cellData.getValue().vacunDerrivaxProperty()).concat(", ")
                .concat(cellData.getValue().vacunVitanegraProperty()).concat(", ")
                .concat(cellData.getValue().vacunCatosalProperty()));
        colgenero.setCellValueFactory(cellData -> cellData.getValue().generoProperty());
        Fechavacunacion.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        tablaRegistro.setItems(observableListaAnimales);
    }

    private void cerrarVentana() {
        Stage stageActual = (Stage) regresar3.getScene().getWindow();
        stageActual.close();
    }
}
