package com.pi4p.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecordUsuarioCadastro(@NotBlank @NotNull String senha, @NotBlank @NotNull String cpf, @NotBlank @NotNull String cargo, @NotBlank @NotNull String nome, int nivel) {
}
