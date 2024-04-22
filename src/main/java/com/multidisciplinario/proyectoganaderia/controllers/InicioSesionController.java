package com.multidisciplinario.proyectoganaderia.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.multidisciplinario.proyectoganaderia.App;
import com.multidisciplinario.proyectoganaderia.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioSesionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button botonEntrar;

    private Usuario usuario = new Usuario();

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(usuario.getUsser()) && password.equals(usuario.getPassword())) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Inicio");
            stage.setScene(scene);
            stage.show();
            cerrarVentana();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de inicio de sesión");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {

    }

    private void cerrarVentana() {
        Stage stageActual = (Stage) botonEntrar.getScene().getWindow();
        stageActual.close();
    }
}
