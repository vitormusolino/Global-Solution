package com.fiap.neuro_mentor.repository;

import com.fiap.neuro_mentor.domain.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}