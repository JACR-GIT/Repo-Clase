package com.practicacontrolpersonas.Controladores;

import com.practicacontrolpersonas.Modelos.Persona;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private TableView<Persona> TBcontenido;
    @FXML
    private TableColumn<Persona, String> CLnombre;
    @FXML
    private TableColumn<Persona, String> CLapellidos;
    @FXML
    private TableColumn<Persona, String> CLedad;

    private ObservableList<Persona> listaPersonas;

    @FXML
    public void initialize() {
        listaPersonas = FXCollections.observableArrayList();
        TBcontenido.setItems(listaPersonas);

        CLnombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        CLapellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        CLedad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEdad()));
    }

    @FXML
    public void HandlerAgregar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/practicacontrolpersonas/Vistas/Desplegable.fxml"));
            Parent root = loader.load();

            DesplegableControlador controlador = loader.getController();
            controlador.setListaPersonas(listaPersonas);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Agregar Persona");
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}