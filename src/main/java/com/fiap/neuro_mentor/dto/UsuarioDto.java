package com.fiap.neuro_mentor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDto(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @Email(message = "Email inválido") @NotBlank String email,
        @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres") String senha,
        @NotBlank(message = "Perfil é obrigatório") String perfil
) {}
