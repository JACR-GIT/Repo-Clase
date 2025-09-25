package com.examenejavafx.Controlador;

import com.examenejavafx.Dao.AnzueloDao;
import com.examenejavafx.Modelo.Anzuelo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.LocalDate;

public class FormularioAñadirController {

    @FXML
    private TextField TxtFieldModelo;
    @FXML
    private TextField TxtFieldColor;
    @FXML
    private TextField TxtFieldOjos;
    @FXML
    private TextField TxtFieldReferencia;
    @FXML
    private TextField TxtFieldNavegabilidad;
    @FXML
    private TextField TxtFieldPeso;
    @FXML
    private TextField TxtFieldDisponobilidad;
    @FXML
    private TextField TxtFieldPVP;
    @FXML
    private ComboBox<String> ComboBoxTamaño;
    @FXML
    private DatePicker DatePickerRecepcion;
    @FXML
    private Button BtnGuardar;

    @FXML
    private void initialize() {
        ComboBoxTamaño.getItems().addAll("Extra Pequeño","Pequeño", "Mediano", "Grande", "Extra Grande");
    }


    public void GuargarAnzuelo(ActionEvent actionEvent) {
        try {
            String modelo = TxtFieldModelo.getText();
            String color = TxtFieldColor.getText();
            String ojos = TxtFieldOjos.getText();
            String referencia = TxtFieldReferencia.getText();
            String navegabilidad = TxtFieldNavegabilidad.getText();
            int peso = Integer.parseInt(TxtFieldPeso.getText());
            String disponibilidad = TxtFieldDisponobilidad.getText();
            int pvp = Integer.parseInt(TxtFieldPVP.getText());
            int tamaño = Integer.parseInt(ComboBoxTamaño.getValue());
            LocalDate fechaRecepcion = DatePickerRecepcion.getValue();

            Anzuelo anzuelo = new Anzuelo(
                    modelo, ojos, color, peso, tamaño, navegabilidad,
                    referencia, disponibilidad, Date.valueOf(fechaRecepcion), pvp
            );

            AnzueloDao dao = new AnzueloDao();
            dao.insertarAnzuelo(anzuelo);

            Stage stage = (Stage) BtnGuardar.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al guardar. Revisa los datos.");
            alert.showAndWait();
        }
    }
}
