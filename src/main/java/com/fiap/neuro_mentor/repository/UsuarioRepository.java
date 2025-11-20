package com.fiap.neuro_mentor.repository;

import com.fiap.neuro_mentor.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
