package com.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnSoma;

    @FXML
    private Button btnSubtracao;

    @FXML
    private Button btnMultiplicacao;

    @FXML
    private Button btnDivisao;

    @FXML
    protected void initialize() {
        // Configuração dos eventos para cada botão
        btnSoma.setOnAction(e -> calcularOperacao('+'));
        btnSubtracao.setOnAction(e -> calcularOperacao('-'));
        btnMultiplicacao.setOnAction(e -> calcularOperacao('*'));
        btnDivisao.setOnAction(e -> calcularOperacao('/'));
    }

    private void calcularOperacao(char operador) {
        try {
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            double resultado = 0;

            switch (operador) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        lblResultado.setText("Erro: Divisão por zero!");
                        return;
                    }
                    break;
            }

            lblResultado.setText(String.format("Resultado: %.2f", resultado));

        } catch (NumberFormatException e) {
            lblResultado.setText("Erro: Entrada inválida!");
        }
    }
}