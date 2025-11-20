package com.fiap.neuro_mentor.dto;

import jakarta.validation.constraints.NotNull;

public record InscricaoDto(
        @NotNull(message = "ID do usuário é obrigatório") Long usuarioId,
        @NotNull(message = "ID da trilha é obrigatório") Long trilhaId
) {}
