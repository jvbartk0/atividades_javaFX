module com.example.semaforo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.semaforo to javafx.fxml;
    exports com.example.semaforo;
}