package com.example.cadastroalunos;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloController {

    // Campos de entrada
    @FXML private TextField nomeField;
    @FXML private TextField idadeField;
    @FXML private ComboBox<String> cursoComboBox;

    // Tabela e botões
    @FXML private TableView<Aluno> tabelaAlunos;
    @FXML private TableColumn<Aluno, String> colunaNome;
    @FXML private TableColumn<Aluno, Integer> colunaIdade;
    @FXML private TableColumn<Aluno, String> colunaCurso;

    @FXML private Button adicionarButton;
    @FXML private Button excluirButton;

    // Lista para armazenar os alunos
    private ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar ComboBox com cursos
        cursoComboBox.getItems().addAll(
                "Engenharia de Software",
                "Ciência da Computação",
                "Sistemas de Informação",
                "Análise e Desenvolvimento de Sistemas",
                "Fisioterapia",
                "Outro"
        );

        // Configurar colunas da tabela
        colunaNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colunaIdade.setCellValueFactory(cellData -> cellData.getValue().idadeProperty().asObject());
        colunaCurso.setCellValueFactory(cellData -> cellData.getValue().cursoProperty());

        // Conectar tabela com a lista
        tabelaAlunos.setItems(listaAlunos);

        // Configurar eventos dos botões
        adicionarButton.setOnAction(event -> adicionarAluno());
        excluirButton.setOnAction(event -> excluirAluno());
    }

    private void adicionarAluno() {
        try {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String curso = cursoComboBox.getValue();

            if (nome.isEmpty() || curso == null) {
                mostrarAlerta("Erro", "Preencha todos os campos!");
                return;
            }

            // Criar novo aluno e adicionar à lista
            Aluno aluno = new Aluno(nome, idade, curso);
            listaAlunos.add(aluno);

            // Limpar campos
            limparCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Digite uma idade válida!");
        }
    }

    private void excluirAluno() {
        Aluno alunoSelecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
        if (alunoSelecionado != null) {
            listaAlunos.remove(alunoSelecionado);
        } else {
            mostrarAlerta("Aviso", "Selecione um aluno para excluir!");
        }
    }

    private void limparCampos() {
        nomeField.clear();
        idadeField.clear();
        cursoComboBox.setValue(null);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}