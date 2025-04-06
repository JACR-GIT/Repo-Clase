package com.practicaControlPersonas.Controlador;

import com.practicaControlPersonas.Modelos.Persona;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtapellidos;
    @FXML
    private TextField txtedad;
    @FXML
    private Button BTagregarpersona;
    @FXML
    private Button BTactualizar;
    @FXML
    private Button BTeliminar;
    @FXML private TableView<Persona> TBcontenido;
    @FXML private TableColumn<Persona, String> CLnombre;
    @FXML private TableColumn<Persona, String> CLapellidos;
    @FXML private TableColumn<Persona, String> CLedad;

    private ObservableList<Persona> listaPersonas;

    public void initialize() {
        listaPersonas = FXCollections.observableArrayList();

        CLnombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        CLapellidos.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getApellidos()));
        CLedad.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEdad()));
    }

    @FXML
    public void HandlerAgregar (ActionEvent event) {
        try{

            String nombre = txtnombre.getText();
            String apellidos = txtapellidos.getText();
            String edad = txtedad.getText();
            System.out.println(nombre + " " + apellidos + " " + edad);

            Persona nuevaPersona = new Persona(nombre, apellidos, edad);
            listaPersonas.add(nuevaPersona);
            TBcontenido.setItems(listaPersonas);

            txtnombre.clear();
            txtapellidos.clear();
            txtedad.clear();
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Formato Incorrecto");
            alert.showAndWait();
        }
    }
    @FXML
    public void HandlerActualizar (ActionEvent event) {
        Persona personaSeleccionada = TBcontenido.getSelectionModel().getSelectedItem();

        if (personaSeleccionada != null) {

            String nombre = txtnombre.getText();
            String apellidos = txtapellidos.getText();
            String edad = txtedad.getText();

            personaSeleccionada.setNombre(nombre);
            personaSeleccionada.setApellidos(apellidos);
            personaSeleccionada.setEdad(edad);

            TBcontenido.refresh();
        }
    }
    @FXML
    public void HandlerEliminar (ActionEvent event) {
        Persona personaSeleccionada = TBcontenido.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null) {
            listaPersonas.remove(personaSeleccionada);
            TBcontenido.setItems(listaPersonas);

            txtnombre.clear();
            txtapellidos.clear();
            txtedad.clear();
        }
    }
}