module com.examenejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.examenejavafx to javafx.fxml;
    exports com.examenejavafx;
    exports com.examenejavafx.Controlador;
    opens com.examenejavafx.Controlador to javafx.fxml;
}