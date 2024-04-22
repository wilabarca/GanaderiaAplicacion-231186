package com.multidisciplinario.proyectoganaderia.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.multidisciplinario.proyectoganaderia.App;
import com.multidisciplinario.proyectoganaderia.models.Animal;
import com.multidisciplinario.proyectoganaderia.models.Registro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EliminarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BotonRegresar2;

    @FXML
    private Button ModificarGanado;

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
    private Button eliminarGanado;

    @FXML
    private TextField inputArete;

    @FXML
    private TableView<Animal> tablaGanado;

    private Registro registro;

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

    @FXML
    void eliminarGanado(ActionEvent event) {
        Animal animalSeleccionado = tablaGanado.getSelectionModel().getSelectedItem();
        if (animalSeleccionado != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Animal");
            alert.setHeaderText("¿Estás seguro de eliminar este animal?");
            alert.setContentText("Se eliminará el animal con número de arete: " + animalSeleccionado.getNumeroArete());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                registro.eliminarAnimal(animalSeleccionado);
                actualizarTable();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un animal para eliminar.");
            alert.showAndWait();
        }
    }

    @FXML
    void modifcarGanado(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ModificarDatos-view.fxml"));
        Parent root = fxmlLoader.load();
        ModificarController modificarController = fxmlLoader.getController();
        modificarController.setRegistro(registro);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Modificar Datos del Ganado");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }


    @FXML
    void initialize() {
        this.registro = new Registro();
        colArete.setCellValueFactory(cellData -> cellData.getValue().numeroAreteProperty().asObject());
        colEdad.setCellValueFactory(cellData -> cellData.getValue().edadProperty().asObject());
        colPeso.setCellValueFactory(cellData -> cellData.getValue().pesoProperty().asObject());
        colPeso1.setCellValueFactory(cellData -> cellData.getValue().generoProperty());
        colPeso2.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        inputArete.textProperty().addListener((observable, oldValue, newValue) -> {
            buscarGanado(newValue);
        });
        actualizarTable();
    }

    private void actualizarTable() {
        ObservableList<Animal> listaAnimales = FXCollections.observableArrayList(registro.getListaAnimales());
        tablaGanado.setItems(listaAnimales);
    }

    private void cerrarVentana() {
        Stage stageActual = (Stage) BotonRegresar2.getScene().getWindow();
        stageActual.close();
    }

    private void buscarGanado(String areteBuscado) {
        ObservableList<Animal> listaAnimales = FXCollections.observableArrayList(registro.getListaAnimales());
        ObservableList<Animal> animalesFiltrados = FXCollections.observableArrayList();
        for (Animal animal : listaAnimales) {
            if (String.valueOf(animal.getNumeroArete()).startsWith(areteBuscado)) {
                animalesFiltrados.add(animal);
            }
        }
        tablaGanado.setItems(animalesFiltrados);
    }

}
