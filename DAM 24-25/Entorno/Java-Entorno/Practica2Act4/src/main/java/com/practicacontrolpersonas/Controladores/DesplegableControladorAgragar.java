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

public class DesplegableControladorAgragar {
    @FXML
    private TextField txt_nombre_desplegable;
    @FXML
    private TextField txt_apellidos_desplegable;
    @FXML
    private TextField txt_edad_desplegable;
    @FXML
    private Button BTsalir;
    @FXML
    private Button BTguardar;

    private ObservableList<Persona> listaPersonas;

    public void setListaPersonas(ObservableList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @FXML
    public void HandlerGuardarDesplegable(ActionEvent event) {
        try {
            String nombre = txt_nombre_desplegable.getText();
            String apellidos = txt_apellidos_desplegable.getText();
            String edad = txt_edad_desplegable.getText();

            Persona nuevaPersona = new Persona(nombre, apellidos, edad);

            boolean personaExiste = listaPersonas.stream().anyMatch(persona -> persona.getNombre().equals(nombre) && persona.getApellidos().equals(apellidos) && persona.getEdad().equals(edad));

            if (personaExiste) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("La persona ya existe en la lista");
                alert.showAndWait();
            } else {
                HelloController.listaPersonas.add(nuevaPersona);

                txt_nombre_desplegable.clear();
                txt_apellidos_desplegable.clear();
                txt_edad_desplegable.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText(null);
                alert.setContentText("Persona Agregada");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error Inesperado: " + e.getMessage());
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