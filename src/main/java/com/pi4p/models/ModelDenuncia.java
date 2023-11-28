package com.pi4p.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "tabela_denuncia")
public class ModelDenuncia {

    @Id
    @GeneratedValue
    UUID denuncia_id;
    String situacao;
    String descricao;
    @Column(nullable = true)
    String parecertecnico;
    @Column(name = "user_id_denunciante", nullable = true)
    String denunciante_id;
    @Column(name = "user_id_revisor")
    String revisor_id;
    String rua;
    String bairro;
    String municipio;
    String CEP;
    @Column(nullable = true)
    String complemento;
    @Column(nullable = true)
    String latitude;
    @Column(nullable = true)
    String logitude;
    String categoria;
    String provavelAutor;

    public ModelDenuncia() {
    }

    public ModelDenuncia(UUID denuncia_id, String situacao, String descricao, String parecertecnico, String denunciante_id, String revisor_id, String rua, String bairro, String municipio, String CEP, String complemento, String latitude, String logitude, String categoria, String provavelAutor) {
        this.denuncia_id = denuncia_id;
        this.situacao = situacao;
        this.descricao = descricao;
        this.parecertecnico = parecertecnico;
        this.denunciante_id = denunciante_id;
        this.revisor_id = revisor_id;
        this.rua = rua;
        this.bairro = bairro;
        this.municipio = municipio;
        this.CEP = CEP;
        this.complemento = complemento;
        this.latitude = latitude;
        this.logitude = logitude;
        this.categoria = categoria;
        this.provavelAutor = provavelAutor;
    }

    public UUID getDenuncia_id() {
        return denuncia_id;
    }

    public void setDenuncia_id(UUID denuncia_id) {
        this.denuncia_id = denuncia_id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getParecertecnico() {
        return parecertecnico;
    }

    public void setParecertecnico(String parecertecnico) {
        this.parecertecnico = parecertecnico;
    }

    public String getDenunciante_id() {
        return denunciante_id;
    }

    public void setDenunciante_id(String denunciante_id) {
        this.denunciante_id = denunciante_id;
    }

    public String getRevisor_id() {
        return revisor_id;
    }

    public void setRevisor_id(String revisor_id) {
        this.revisor_id = revisor_id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogitude() {
        return logitude;
    }

    public void setLogitude(String logitude) {
        this.logitude = logitude;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProvavelAutor() {
        return provavelAutor;
    }

    public void setProvavelAutor(String provavelAutor) {
        this.provavelAutor = provavelAutor;
    }
}
