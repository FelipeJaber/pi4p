package com.pi4p.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tabela_usuarios")
public class ModelUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    UUID userid;
    @Column(length = 11)
    String CPF;
    @Column(length = 25)
    String nome;
    @Column(length = 10)
    String cargo;
    int nivel;

    public ModelUsuario() {
    }

    public ModelUsuario(UUID id, String CPF, String nome, String cargo, int nivel) {
        this.userid = id;
        this.CPF = CPF;
        this.nome = nome;
        this.cargo = cargo;
        this.nivel = nivel;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
