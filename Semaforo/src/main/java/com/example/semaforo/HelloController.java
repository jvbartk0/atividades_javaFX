package com.example.semaforo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class HelloController {

    // Círculos do semáforo
    @FXML private Circle luzVermelha;
    @FXML private Circle luzAmarela;
    @FXML private Circle luzVerde;

    // Botões e label
    @FXML private Button iniciarButton;
    @FXML private Button pararButton;
    @FXML private Label estadoLabel;

    // Timer para controle das luzes
    private Timeline timeline;
    private int estadoAtual = 0; // 0=vermelho, 1=amarelo, 2=verde

    @FXML
    public void initialize() {
        // Configurar eventos dos botões
        iniciarButton.setOnAction(event -> iniciarSemaforo());
        pararButton.setOnAction(event -> pararSemaforo());

        // Inicializar semáforo desligado
        desligarTodasLuzes();
        pararButton.setDisable(true);
    }

    private void iniciarSemaforo() {
        // Criar timeline que se repete a cada 2 segundos
        timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> trocarLuz()));
        timeline.setCycleCount(Timeline.INDEFINITE); // Loop infinito
        timeline.play();

        // Atualizar interface
        iniciarButton.setDisable(true);
        pararButton.setDisable(false);
        estadoLabel.setText("Semáforo: INICIADO");
    }

    private void pararSemaforo() {
        if (timeline != null) {
            timeline.stop();
        }

        // Atualizar interface
        iniciarButton.setDisable(false);
        pararButton.setDisable(true);
        desligarTodasLuzes();
        estadoLabel.setText("Semáforo: PARADO");
    }

    private void trocarLuz() {
        // Desligar todas as luzes primeiro
        desligarTodasLuzes();

        // Ativar luz conforme estado atual
        switch (estadoAtual) {
            case 0: // Vermelho
                luzVermelha.setFill(Color.RED);
                estadoLabel.setText("PARE");
                estadoAtual = 1;
                break;
            case 1: // Amarelo
                luzAmarela.setFill(Color.YELLOW);
                estadoLabel.setText("ATENÇÃO");
                estadoAtual = 2;
                break;
            case 2: // Verde
                luzVerde.setFill(Color.GREEN);
                estadoLabel.setText("SIGA");
                estadoAtual = 0;
                break;
        }
    }

    private void desligarTodasLuzes() {
        // Define cores "apagadas" para todas as luzes
        luzVermelha.setFill(Color.rgb(50, 0, 0));     // Vermelho escuro
        luzAmarela.setFill(Color.rgb(50, 50, 0));     // Amarelo escuro
        luzVerde.setFill(Color.rgb(0, 50, 0));        // Verde escuro
    }
}