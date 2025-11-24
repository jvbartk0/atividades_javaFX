package com.example.lanchonete;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    // Componentes da interface
    @FXML private TextField nomeField;
    @FXML private ComboBox<String> paoComboBox;
    @FXML private RadioButton bovinaRadio;
    @FXML private RadioButton frangoRadio;
    @FXML private RadioButton sojaRadio;
    @FXML private CheckBox queijoCheck;
    @FXML private CheckBox baconCheck;
    @FXML private CheckBox saladaCheck;
    @FXML private CheckBox molhoCheck;
    @FXML private Button gerarButton;
    @FXML private Label resultadoLabel;

    @FXML
    public void initialize() {
        // Configurar ComboBox de pães
        paoComboBox.getItems().addAll("francês", "integral", "australiano");

        // Configurar grupo para RadioButtons de carne
        ToggleGroup carneToggleGroup = new ToggleGroup();
        bovinaRadio.setToggleGroup(carneToggleGroup);
        frangoRadio.setToggleGroup(carneToggleGroup);
        sojaRadio.setToggleGroup(carneToggleGroup);

        // Configurar evento do botão
        gerarButton.setOnAction(event -> gerarPedido());
    }

    private void gerarPedido() {
        try {
            String nome = nomeField.getText();
            String pao = paoComboBox.getValue();

            // Verificar carne selecionada
            String carne = "";
            if (bovinaRadio.isSelected()) carne = "bovina";
            else if (frangoRadio.isSelected()) carne = "frango";
            else if (sojaRadio.isSelected()) carne = "soja";

            // Validar campos obrigatórios
            if (nome.isEmpty() || pao == null || carne.isEmpty()) {
                resultadoLabel.setText("Erro: Preencha nome, pão e carne!");
                return;
            }

            // Montar lista de adicionais
            StringBuilder adicionais = new StringBuilder();
            if (queijoCheck.isSelected()) adicionais.append("queijo, ");
            if (baconCheck.isSelected()) adicionais.append("bacon, ");
            if (saladaCheck.isSelected()) adicionais.append("salada, ");
            if (molhoCheck.isSelected()) adicionais.append("molho, ");

            // Formatar adicionais
            String textoAdicionais;
            if (adicionais.length() > 0) {
                // Remove a última vírgula e espaço
                adicionais.setLength(adicionais.length() - 2);
                textoAdicionais = "com " + adicionais.toString();
            } else {
                textoAdicionais = "sem adicionais";
            }

            // Montar mensagem final
            String mensagem = String.format("Pedido de %s: pão %s com carne %s, %s.",
                    nome, pao, carne, textoAdicionais);

            resultadoLabel.setText(mensagem);

        } catch (Exception e) {
            resultadoLabel.setText("Erro: Preencha todos os campos obrigatórios!");
        }
    }
}