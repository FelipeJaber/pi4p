package com.pi4p.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tabela_usuarios")
public class ModelUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String nome;
    String CPF;
    String senha;

    public ModelUsuario() {
    }

    public ModelUsuario(UUID id, String nome, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.CPF = cpf;
        this.senha = senha;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return CPF;
    }

    public void setCpf(String cpf) {
        this.CPF = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
