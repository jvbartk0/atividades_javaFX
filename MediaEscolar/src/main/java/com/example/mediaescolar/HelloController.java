package com.example.mediaescolar;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML private TextField nomeField;
    @FXML private TextField nota1Field;
    @FXML private TextField nota2Field;
    @FXML private TextField nota3Field;
    @FXML private Button calcularButton;
    @FXML private Label resultadoLabel;

    @FXML
    public void initialize() {
        calcularButton.setOnAction(event -> calcularMedia());
    }

    private void calcularMedia() {
        try {
            // Obter dados dos campos
            String nome = nomeField.getText();
            double nota1 = Double.parseDouble(nota1Field.getText());
            double nota2 = Double.parseDouble(nota2Field.getText());
            double nota3 = Double.parseDouble(nota3Field.getText());

            // Calcular média
            double media = (nota1 + nota2 + nota3) / 3;

            // Determinar situação
            String situacao;
            if (media >= 7) {
                situacao = "Aprovado";
            } else if (media >= 4) {
                situacao = "Recuperação";
            } else {
                situacao = "Reprovado";
            }

            // Montar mensagem de resultado
            String mensagem = String.format("Aluno %s — média: %.1f — %s.", nome, media, situacao);
            resultadoLabel.setText(mensagem);

        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Digite notas válidas!");
        } catch (Exception e) {
            resultadoLabel.setText("Erro: Preencha todos os campos!");
        }
    }
}