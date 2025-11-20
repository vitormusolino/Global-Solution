package com.fiap.neuro_mentor.service;

import com.fiap.neuro_mentor.domain.Trilha;
import com.fiap.neuro_mentor.dto.TrilhaDto;
import com.fiap.neuro_mentor.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository repository;

    public TrilhaService(TrilhaRepository repository) {
        this.repository = repository;
    }

    public Trilha salvar(TrilhaDto dto) {
        Trilha trilha = new Trilha();
        trilha.setTitulo(dto.titulo());
        trilha.setCategoria(dto.categoria());
        trilha.setCargaHoraria(dto.cargaHoraria());
        trilha.setNivel(dto.nivel());
        return repository.save(trilha);
    }

    public List<Trilha> listar() {
        return repository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Trilha não encontrada"));
    }

    public Trilha atualizar(Long id, TrilhaDto dto) {
        Trilha trilha = buscarPorId(id);
        trilha.setTitulo(dto.titulo());
        trilha.setCategoria(dto.categoria());
        trilha.setCargaHoraria(dto.cargaHoraria());
        trilha.setNivel(dto.nivel());
        return repository.save(trilha);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
