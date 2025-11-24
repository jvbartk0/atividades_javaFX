module com.example.adivinhacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.adivinhacao to javafx.fxml;
    exports com.example.adivinhacao;
}