package com.pi4p.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecordUsuario(String nome,@NotBlank @NotNull String senha, @NotBlank @NotNull String cpf) {
}
