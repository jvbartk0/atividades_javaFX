module com.example.conversordetemperatura {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.conversordetemperatura to javafx.fxml, javafx.graphics;
    exports com.example.conversordetemperatura;
}