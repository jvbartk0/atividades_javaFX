module com.example.contadeluz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contadeluz to javafx.fxml;
    exports com.example.contadeluz;
}