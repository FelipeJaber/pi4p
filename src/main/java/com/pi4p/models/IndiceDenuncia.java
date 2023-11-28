package com.pi4p.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "indice_denuncia")
public class IndiceDenuncia {

    @Id
    @GeneratedValue
    UUID ind_denuncia_id;
    String denuncia_id;
    @Column(name = "user_id_denunciante")
    String denunciante_id;
    @Column(name = "user_id_revisor")
    String revidor_id;
    String ultima_atualizacao;
}
