module org.example.controlpersonaspract2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.controlpersonaspract2 to javafx.fxml;
    exports org.example.controlpersonaspract2;
}