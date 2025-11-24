package com.example.adivinhacao;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;

public class HelloController {

    // Componentes da interface
    @FXML private TextField numeroField;
    @FXML private Button verificarButton;
    @FXML private Button tentarNovamenteButton;
    @FXML private Label resultadoLabel;
    @FXML private Label instrucaoLabel;

    // Variáveis do jogo
    private int numeroSecreto;
    private Random random;
    private boolean jogoAtivo;

    @FXML
    public void initialize() {
        random = new Random();

        // Configurar eventos dos botões
        verificarButton.setOnAction(event -> verificarPalpite());
        tentarNovamenteButton.setOnAction(event -> iniciarNovoJogo());

        // Iniciar primeiro jogo
        iniciarNovoJogo();
    }

    private void iniciarNovoJogo() {
        // Gerar novo número secreto (1 a 10)
        numeroSecreto = random.nextInt(10) + 1;
        jogoAtivo = true;

        // Limpar e preparar interface
        numeroField.clear();
        numeroField.setDisable(false);
        verificarButton.setDisable(false);
        tentarNovamenteButton.setDisable(true);
        resultadoLabel.setText("Tente adivinhar o número!");
        instrucaoLabel.setText("Digite um número de 1 a 10");

        // Debug (remover em produção)
        System.out.println("Número secreto: " + numeroSecreto);
    }

    private void verificarPalpite() {
        if (!jogoAtivo) return;

        try {
            int palpite = Integer.parseInt(numeroField.getText());

            // Validar intervalo
            if (palpite < 1 || palpite > 10) {
                resultadoLabel.setText("Erro: Digite um número entre 1 e 10!");
                return;
            }

            // Verificar se acertou
            if (palpite == numeroSecreto) {
                resultadoLabel.setText("🎉 Acertou! Parabéns!");
                instrucaoLabel.setText("O número era " + numeroSecreto);
                finalizarJogo();
            } else {
                resultadoLabel.setText("❌ Errou! Tente novamente.");

                // Dar dica
                if (palpite < numeroSecreto) {
                    instrucaoLabel.setText("Dica: O número é MAIOR que " + palpite);
                } else {
                    instrucaoLabel.setText("Dica: O número é MENOR que " + palpite);
                }
            }

        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Digite um número válido!");
        }
    }

    private void finalizarJogo() {
        jogoAtivo = false;
        numeroField.setDisable(true);
        verificarButton.setDisable(true);
        tentarNovamenteButton.setDisable(false);
    }
}