package com.example.cadastroanalisedepessoas;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TextField nomeField;
    @FXML private TextField idadeField;
    @FXML private RadioButton masculinoRadio;
    @FXML private RadioButton femininoRadio;
    @FXML private CheckBox esportesCheck;
    @FXML private Button analisarButton;
    @FXML private Label resultadoLabel;

    @FXML
    public void initialize() {
        ToggleGroup sexoToggleGroup = new ToggleGroup();
        masculinoRadio.setToggleGroup(sexoToggleGroup);
        femininoRadio.setToggleGroup(sexoToggleGroup);
        analisarButton.setOnAction(event -> analisarPessoa());
    }

    private void analisarPessoa() {
        try {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String sexo = masculinoRadio.isSelected() ? "masculino" : femininoRadio.isSelected() ? "feminino" : "";
            String esportes = esportesCheck.isSelected() ? "gosta" : "não gosta";
            String maioridade = idade < 18 ? "Menor de idade." : "Maior de idade.";

            String mensagem = nome + ", " + idade + " anos, do sexo " + sexo + ", " + esportes + " de esportes.\n" + maioridade;
            resultadoLabel.setText(mensagem);
        } catch (Exception e) {
            resultadoLabel.setText("Erro: Preencha todos os campos corretamente!");
        }
    }
}