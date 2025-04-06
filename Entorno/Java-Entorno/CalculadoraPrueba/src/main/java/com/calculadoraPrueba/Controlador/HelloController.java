package com.calculadoraPrueba.Controlador;

import com.calculadoraPrueba.Modelo.Dividir;
import com.calculadoraPrueba.Modelo.Multiplicar;
import com.calculadoraPrueba.Modelo.Restar;
import com.calculadoraPrueba.Modelo.Suma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtop1;
    @FXML
    private TextField txtop2;
    @FXML
    private TextField txtresultado;
    @FXML
    private Button BToperar;
    @FXML
    private RadioButton RBsumar;
    @FXML
    private RadioButton RBrestar;
    @FXML
    private RadioButton RBdividir;
    @FXML
    private RadioButton RBmultiplicar;


    @FXML
    public void HandlerOperar(ActionEvent actionEvent) {
        try{
            int op1 = Integer.parseInt(txtop1.getText());
            int op2 = Integer.parseInt(txtop2.getText());

            double resultado = 0;
            
            if (RBsumar.isSelected()) {
                Suma suma = new Suma(op1, op2);
                resultado = suma.sumar();
            } else if (RBrestar.isSelected()) {
                Restar restar = new Restar(op1, op2);
                resultado = restar.restar();
            } else if (RBmultiplicar.isSelected()) {
                Multiplicar multiplicar = new Multiplicar(op1, op2);
                resultado = multiplicar.multiplicar();
            } else if (RBmultiplicar.isSelected()) {
                Dividir dividir = new Dividir(op1, op2);
                resultado = dividir.dividir();
            }
        
            this.txtresultado.setText(String.valueOf(resultado));
            
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Formato Incorrecto");
            alert.showAndWait();
        }
    }
}