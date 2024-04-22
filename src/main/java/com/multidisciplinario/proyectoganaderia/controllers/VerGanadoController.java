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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerGanadoController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BotonRegresar2;

    @FXML
    private TableColumn<Animal, Integer> colArete;

    @FXML
    private TableColumn<Animal, Integer> colEdad;

    @FXML
    private TableColumn<Animal, Double> colPeso;

    @FXML
    private TableColumn<Animal, String> colPeso1;

    @FXML
    private TableColumn<Animal, String> colPeso2;

    @FXML
    private TextField inputArete;

    @FXML
    private TableView<Animal> tablaDatos;

    @FXML
    private TableView<Animal> TablaVacunas;

    @FXML
    private TableColumn<Animal, String> DectomaxColumn;

    @FXML
    private TableColumn<Animal, String> GanavermColumn;

    @FXML
    private TableColumn<Animal, String> AdbacColumn;

    @FXML
    private TableColumn<Animal, String> DerrivaxColumn;

    @FXML
    private TableColumn<Animal, String> VitanegraColumn;

    @FXML
    private TableColumn<Animal, String> CatosalColumn;

    private Registro registro = new Registro();

    @FXML
    void RegresarMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    void buscarGanado() {
        String areteBuscado = inputArete.getText().trim();
        if (areteBuscado.isEmpty()) {
            actualizarTable();
            return;
        }

        ObservableList<Animal> listaAnimales = FXCollections.observableArrayList(registro.getListaAnimales());
        ObservableList<Animal> animalesEncontrados = FXCollections.observableArrayList();
        for (Animal animal : listaAnimales) {
            if (String.valueOf(animal.getNumeroArete()).contains(areteBuscado)) {
                animalesEncontrados.add(animal);
            }
        }

        tablaDatos.setItems(animalesEncontrados);
        TablaVacunas.setItems(animalesEncontrados);
    }


    @FXML
    void initialize() {
        actualizarTable();
        inputArete.textProperty().addListener((observable, oldValue, newValue) -> {
            buscarGanado();
        });
    }

    private void actualizarTable (){
        ObservableList<Animal> listaAnimales = FXCollections.observableArrayList(registro.getListaAnimales());
        colArete.setCellValueFactory(cellData -> cellData.getValue().numeroAreteProperty().asObject());
        colEdad.setCellValueFactory(cellData -> cellData.getValue().edadProperty().asObject());
        colPeso.setCellValueFactory(cellData -> cellData.getValue().pesoProperty().asObject());
        colPeso1.setCellValueFactory(cellData -> cellData.getValue().generoProperty());
        colPeso2.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        DectomaxColumn.setCellValueFactory(cellData -> cellData.getValue().vacunDectomaxProperty());
        GanavermColumn.setCellValueFactory(cellData -> cellData.getValue().vacunGanavermProperty());
        AdbacColumn.setCellValueFactory(cellData -> cellData.getValue().vacunAdbacProperty());
        DerrivaxColumn.setCellValueFactory(cellData -> cellData.getValue().vacunDerrivaxProperty());
        VitanegraColumn.setCellValueFactory(cellData -> cellData.getValue().vacunVitanegraProperty());
        CatosalColumn.setCellValueFactory(cellData -> cellData.getValue().vacunCatosalProperty());
        tablaDatos.setItems(listaAnimales);
        TablaVacunas.setItems(listaAnimales);
    }
    private void cerrarVentana() {
        Stage stageActual = (Stage) BotonRegresar2.getScene().getWindow();
        stageActual.close();
    }

}
