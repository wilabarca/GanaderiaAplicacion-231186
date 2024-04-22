module com.multidisciplinario.proyectoganaderia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.multidisciplinario.proyectoganaderia to javafx.fxml;
    exports com.multidisciplinario.proyectoganaderia;
    exports com.multidisciplinario.proyectoganaderia.controllers;
    opens com.multidisciplinario.proyectoganaderia.controllers to javafx.fxml;
}