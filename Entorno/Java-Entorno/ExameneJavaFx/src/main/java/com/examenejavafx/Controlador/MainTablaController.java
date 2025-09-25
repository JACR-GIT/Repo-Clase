package com.examenejavafx.Controlador;

import com.examenejavafx.Dao.AnzueloDao;
import com.examenejavafx.Modelo.Anzuelo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainTablaController {

    @FXML
    private Button BtnNuevo;
    @FXML
    private ComboBox<String> ComboBoxTamañoBusqueda;
    @FXML
    private TextField TxtFlieldModeloBusqueda;
    @FXML
    private TableView<Anzuelo> tableView;
    @FXML
    private TableColumn<Anzuelo, String> ColumModelo;
    @FXML
    private TableColumn<Anzuelo, Integer> ColumTamaño;
    @FXML
    private TableColumn<Anzuelo, String> ColumColor;
    @FXML
    private TableColumn<Anzuelo, String> ColumNavegabilidad;
    @FXML
    private TableColumn<Anzuelo, String> ColumOjos;
    @FXML
    private TableColumn<Anzuelo, Integer> ColumPeso;
    @FXML
    private TableColumn<Anzuelo, String> ColumDisponibilidad;
    @FXML
    private TableColumn<Anzuelo, Integer> ColumPVP;
    @FXML
    private TableColumn<Anzuelo, String> ColumReferencia;

    @FXML
    private void initialize() {
        ColumModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        ColumTamaño.setCellValueFactory(new PropertyValueFactory<>("tamaño"));
        ColumColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        ColumNavegabilidad.setCellValueFactory(new PropertyValueFactory<>("navegabilidad"));
        ColumOjos.setCellValueFactory(new PropertyValueFactory<>("ojos"));
        ColumPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        ColumDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
        ColumPVP.setCellValueFactory(new PropertyValueFactory<>("PVP"));
        ColumReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));

        cargarAnzuelos();
    }

    private void cargarAnzuelos() {
        AnzueloDao dao = new AnzueloDao();
        List<Anzuelo> lista = dao.obtenerTodosAnzuelos();
        ObservableList<Anzuelo> anzuelos = FXCollections.observableArrayList(lista);
        tableView.setItems(anzuelos);
    }

    @FXML
    private void NuevoAnzuelo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/examenejavafx/Vista/FormularioAñadir.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Añadir Anzuelo");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}