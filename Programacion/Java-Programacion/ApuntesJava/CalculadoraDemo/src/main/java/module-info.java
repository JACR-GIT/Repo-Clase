module com.example.Modelo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.example.Modelo to javafx.fxml;
    exports com.example.Modelo;
    exports Controlador;
    opens Controlador to javafx.fxml;
}