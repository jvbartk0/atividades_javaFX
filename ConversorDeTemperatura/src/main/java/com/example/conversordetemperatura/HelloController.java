package com.example.conversordetemperatura;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// MUDE O NOME DA CLASSE para HelloController
public class HelloController {

    @FXML
    private TextField temperaturaField;

    @FXML
    private Button converterParaFButton;

    @FXML
    private Button converterParaCButton;

    @FXML
    private Label resultadoLabel;

    @FXML
    private void converterParaFahrenheit() {
        try {
            double celsius = Double.parseDouble(temperaturaField.getText());
            double fahrenheit = (celsius * 9/5) + 32;
            resultadoLabel.setText(celsius + "°C = " + fahrenheit + "°F");
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Digite um número válido!");
        }
    }

    @FXML
    private void converterParaCelsius() {
        try {
            double fahrenheit = Double.parseDouble(temperaturaField.getText());
            double celsius = (fahrenheit - 32) * 5/9;
            resultadoLabel.setText(fahrenheit + "°F = " + celsius + "°C");
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Digite um número válido!");
        }
    }
}