package com.practicacontrolpersonas.Controladores;

import com.practicacontrolpersonas.Modelos.Persona;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DesplegableControladorModificar {
    @FXML
    private TextField txt_nombre_desplegable;
    @FXML
    private TextField txt_apellidos_desplegable;
    @FXML
    private TextField txt_edad_desplegable;
    @FXML
    private Button BTsalir;
    @FXML
    private Button BTModificar;

    private ObservableList<Persona> listaPersonas;
    private Persona personaSeleccionada;

    public void setListaPersonas(ObservableList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
        if (personaSeleccionada != null) {
            txt_nombre_desplegable.setText(personaSeleccionada.getNombre());
            txt_apellidos_desplegable.setText(personaSeleccionada.getApellidos());
            txt_edad_desplegable.setText(personaSeleccionada.getEdad());
        }
    }

    @FXML
    public void HandlerModificarDesplegable(ActionEvent event) {
        try {
            if (personaSeleccionada != null) {

                personaSeleccionada.setNombre(txt_nombre_desplegable.getText());
                personaSeleccionada.setApellidos(txt_apellidos_desplegable.getText());
                personaSeleccionada.setEdad(txt_edad_desplegable.getText());

                listaPersonas.set(listaPersonas.indexOf(personaSeleccionada), personaSeleccionada);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText(null);
                alert.setContentText("Persona modificada correctamente");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Advertencia");
                alert.setHeaderText(null);
                alert.setContentText("No se ha seleccionado ninguna persona para modificar");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error inesperado: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void HandlerSalir(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/practicacontrolpersonas/Vistas/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Controlador de Personas");
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.BTsalir.getScene().getWindow();
            myStage.close();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error inesperado: " + e.getMessage());
            alert.showAndWait();
        }
    }
}