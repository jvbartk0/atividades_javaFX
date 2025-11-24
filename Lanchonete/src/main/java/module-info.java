module com.example.lanchonete {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lanchonete to javafx.fxml;
    exports com.example.lanchonete;
}