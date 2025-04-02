package com.example.Controlador;

import com.example.Modelo.Suma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public void HandlerSumar(ActionEvent actionEvent) {
        try{
            double op1 = Double.parseDouble(txtop1.getText());
            double op2 = Double.parseDouble(txtop2.getText());

            Suma suma = new Suma(op1, op2);
            this.txtresultado.setText(String.valueOf(suma.sumar()));
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Formato Incorrecto");
            alert.showAndWait();
        }
    }
}