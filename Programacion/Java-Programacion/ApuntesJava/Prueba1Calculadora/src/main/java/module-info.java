module com.example.Modelo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Controlador to javafx.fxml;
    exports com.example.Controlador;
}