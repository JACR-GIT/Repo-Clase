module org.example.practican2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.practican2 to javafx.fxml;
    exports org.example.practican2;
}