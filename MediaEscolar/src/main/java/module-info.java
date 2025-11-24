module com.example.mediaescolar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mediaescolar to javafx.fxml;
    exports com.example.mediaescolar;
}