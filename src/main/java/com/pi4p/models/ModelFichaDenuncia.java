package com.pi4p.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "fichas_denuncia")
public class ModelFichaDenuncia {

    @Id
    @GeneratedValue
    UUID ficha_denuncia_id;
    String denuncia_id;
    String status;
    String data;
    @Column(name = "user_id_revisor")
    String revisor_id;
    String comentario;

}
