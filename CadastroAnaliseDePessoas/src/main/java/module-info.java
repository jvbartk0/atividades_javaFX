module com.example.cadastroanalisedepessoas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.cadastroanalisedepessoas to javafx.fxml, javafx.graphics;
    exports com.example.cadastroanalisedepessoas;
}