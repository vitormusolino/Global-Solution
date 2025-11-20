package com.fiap.neuro_mentor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TrilhaDto(
        @NotBlank(message = "Título é obrigatório") String titulo,
        @NotBlank(message = "Categoria é obrigatória") String categoria,
        @NotNull(message = "Carga horária é obrigatória") Integer cargaHoraria,
        @NotBlank(message = "Nível é obrigatório") String nivel
) {}
