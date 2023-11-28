package com.pi4p.repository;

import com.pi4p.models.ModelSenha;
import com.pi4p.models.ModelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SenhaRepository extends JpaRepository<ModelSenha, UUID> {
    Optional<ModelSenha> findByuserid(String userid);
}
