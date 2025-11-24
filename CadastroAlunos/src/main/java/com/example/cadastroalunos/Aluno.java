package com.example.cadastroalunos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Aluno {
    private SimpleStringProperty nome;
    private SimpleIntegerProperty idade;
    private SimpleStringProperty curso;

    public Aluno(String nome, int idade, String curso) {
        this.nome = new SimpleStringProperty(nome);
        this.idade = new SimpleIntegerProperty(idade);
        this.curso = new SimpleStringProperty(curso);
    }

    // Getters para propriedades (usados pela TableView)
    public SimpleStringProperty nomeProperty() { return nome; }
    public SimpleIntegerProperty idadeProperty() { return idade; }
    public SimpleStringProperty cursoProperty() { return curso; }

    // Getters normais
    public String getNome() { return nome.get(); }
    public int getIdade() { return idade.get(); }
    public String getCurso() { return curso.get(); }

    // Setters
    public void setNome(String nome) { this.nome.set(nome); }
    public void setIdade(int idade) { this.idade.set(idade); }
    public void setCurso(String curso) { this.curso.set(curso); }
}