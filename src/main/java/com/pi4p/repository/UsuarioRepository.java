package com.pi4p.repository;

import com.pi4p.models.ModelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<ModelUsuario, UUID> {

    Optional<ModelUsuario> findByCPF(String CPF);
}
