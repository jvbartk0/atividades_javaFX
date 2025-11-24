package com.example.contadeluz;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    // Componentes da interface
    @FXML private TextField nomeField;
    @FXML private TextField consumoField;
    @FXML private ComboBox<String> tipoComboBox;
    @FXML private Button calcularButton;
    @FXML private Label resultadoLabel;
    @FXML private Label tarifasLabel;

    // Tarifas por kWh
    private final double TARIFA_RESIDENCIAL = 0.60;
    private final double TARIFA_COMERCIAL = 0.48;
    private final double TARIFA_INDUSTRIAL = 0.75;

    @FXML
    public void initialize() {
        // Configurar ComboBox com tipos de residência
        tipoComboBox.getItems().addAll("residencial", "comercial", "industrial");

        // Configurar evento do botão
        calcularButton.setOnAction(event -> calcularConta());

        // Mostrar tarifas
        tarifasLabel.setText(String.format(
                "Tarifas: Residencial R$ %.2f/kWh | Comercial R$ %.2f/kWh | Industrial R$ %.2f/kWh",
                TARIFA_RESIDENCIAL, TARIFA_COMERCIAL, TARIFA_INDUSTRIAL
        ));
    }

    private void calcularConta() {
        try {
            String nome = nomeField.getText();
            double consumo = Double.parseDouble(consumoField.getText());
            String tipo = tipoComboBox.getValue();

            // Validar campos
            if (nome.isEmpty() || tipo == null) {
                resultadoLabel.setText("Erro: Preencha todos os campos!");
                return;
            }

            if (consumo <= 0) {
                resultadoLabel.setText("Erro: Consumo deve ser maior que zero!");
                return;
            }

            // Calcular valor conforme o tipo
            double tarifa = 0;
            switch (tipo) {
                case "residencial":
                    tarifa = TARIFA_RESIDENCIAL;
                    break;
                case "comercial":
                    tarifa = TARIFA_COMERCIAL;
                    break;
                case "industrial":
                    tarifa = TARIFA_INDUSTRIAL;
                    break;
            }

            double valor = consumo * tarifa;

            // Formatar resultado
            String mensagem = String.format(
                    "Cliente: %s — Tipo: %s — Consumo: %.0f kWh — Valor: R$ %.2f",
                    nome, tipo, consumo, valor
            );

            resultadoLabel.setText(mensagem);

        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Digite um consumo válido!");
        } catch (Exception e) {
            resultadoLabel.setText("Erro: Preencha todos os campos corretamente!");
        }
    }
}