package com.pi4p.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tabela_senha")
public class ModelSenha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID pass_id;
    String senha;
    String salt;
    @Column(name = "user_id")
    String userid;

    public ModelSenha() {
    }

    public ModelSenha(UUID pass_id, String senha, String salt, String user_id) {
        this.pass_id = pass_id;
        this.senha = senha;
        this.salt = salt;
        this.userid = user_id;
    }

    public UUID getPass_id() {
        return pass_id;
    }

    public void setPass_id(UUID pass_id) {
        this.pass_id = pass_id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
