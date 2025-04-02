module com.example.Controlador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.Controlador to javafx.fxml;
    exports com.example.Controlador;
}