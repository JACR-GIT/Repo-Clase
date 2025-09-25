package com.practicacontrolpersonas.Controladores;

import com.practicacontrolpersonas.Modelos.Persona;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField txt_filtro_nombre;

    public static ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        FilteredList<Persona> listaFiltrada = new FilteredList<>(listaPersonas, p -> true);

        SortedList<Persona> listaOrdenada = new SortedList<>(listaFiltrada);
        listaOrdenada.comparatorProperty().bind(TBcontenido.comparatorProperty());

        TBcontenido.setItems(listaOrdenada);

        CLnombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        CLapellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        CLedad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEdad()));

        txt_filtro_nombre.textProperty().addListener((observable, oldValue, newValue) -> {
            listaFiltrada.setPredicate(persona -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String textoFiltro = newValue.toLowerCase();
                return persona.getNombre().toLowerCase().contains(textoFiltro);
            });
        });
    }

    @FXML
    public void HandlerAgregar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/practicacontrolpersonas/Vistas/DesplegableAgregar.fxml"));
            Parent root = loader.load();

            DesplegableControladorAgragar controlador = loader.getController();
            controlador.setListaPersonas(listaPersonas);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Agregar Persona");

            stage.show();
            Stage myStage = (Stage) this.txt_filtro_nombre.getScene().getWindow();
            myStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void HandlerModificar(ActionEvent actionEvent) {
        Persona personaSeleccionada = TBcontenido.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/practicacontrolpersonas/Vistas/DesplegableModificar.fxml"));
                Parent root = loader.load();

                DesplegableControladorModificar controlador = loader.getController();
                controlador.setListaPersonas(listaPersonas);
                controlador.setPersonaSeleccionada(personaSeleccionada);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Modificar Persona");

                stage.show();
                Stage myStage = (Stage) this.txt_filtro_nombre.getScene().getWindow();
                myStage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar una persona para modificar");
            alert.showAndWait();
        }
    }

    @FXML
    public void HandlerEliminar(ActionEvent event) {
        Persona personaSeleccionada = TBcontenido.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null) {
            listaPersonas.remove(personaSeleccionada);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar una persona para eliminar");
            alert.showAndWait();
        }
    }
}