package com.pi4p.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RecordCriarDenuncia(@NotBlank @NotNull String categoria,@NotBlank @NotNull String token, @NotBlank @NotNull String id_denunciante, @NotBlank @NotNull String rua, @NotBlank @NotNull String bairro, @NotBlank @NotNull String municipio, @NotBlank @NotNull String cep, @NotBlank @NotNull String descricao, @NotBlank @NotNull String data, @NotBlank @NotNull List<String> fotos, String complemento, String latitude, String longitude, String provavelautor) {
}
