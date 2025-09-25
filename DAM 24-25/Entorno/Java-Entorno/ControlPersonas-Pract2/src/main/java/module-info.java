module org.example.controlpersonaspract2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.Controlador to javafx.fxml;
    exports org.example.Controlador;
    opens org.example.controlpersonaspract2.Vista to javafx.fxml;
}