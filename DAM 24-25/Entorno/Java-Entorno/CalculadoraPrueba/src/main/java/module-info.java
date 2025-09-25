module com.calculadoraPrueba.Controlador {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calculadoraPrueba.Controlador to javafx.fxml;
    exports com.calculadoraPrueba.Controlador;
    opens com.calculadoraPrueba.Vista to javafx.fxml;
}