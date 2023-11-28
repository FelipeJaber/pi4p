package com.pi4p.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecordUsuarioAutenticado(@NotBlank @NotNull String token) {
}
