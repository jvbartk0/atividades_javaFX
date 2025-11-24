module com.example.cadastroalunos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cadastroalunos to javafx.fxml;
    exports com.example.cadastroalunos;
}