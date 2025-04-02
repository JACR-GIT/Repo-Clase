package com.example.Controlador;
import com.example.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class HelloController {
    @FXML
    private TextField txtop1;
    @FXML
    private TextField txtop2;
    @FXML
    private TextField txtresultado;
    @FXML
    private Button Sumar;

    @FXML
    private void HandlerSumar(javafx.event.ActionEvent actionEvent) {
        try {
            double op1 = Double.parseDouble(txtop1.getText());
            double op2 = Double.parseDouble(txtop2.getText());

            Suma suma = new Suma(op1, op2);
            this.txtresultado.setText(String.valueOf(suma.sumar()));
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Formato Incorrecto");
            alert.showAndWait();
        }
    }

}