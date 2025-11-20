package com.fiap.neuro_mentor.service;

import com.fiap.neuro_mentor.domain.Inscricao;
import com.fiap.neuro_mentor.dto.InscricaoDto;
import com.fiap.neuro_mentor.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository repository;

    public InscricaoService(InscricaoRepository repository) {
        this.repository = repository;
    }

    public Inscricao salvar(InscricaoDto dto) {
        Inscricao inscricao = new Inscricao(null, dto.usuarioId(), dto.trilhaId());
        return repository.save(inscricao);
    }

    public List<Inscricao> listar() {
        return repository.findAll();
    }

    public Inscricao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inscrição não encontrada"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Inscricao inscrever(InscricaoDto dto) {
        return salvar(dto);
    }

    public void cancelar(Long id) {
        excluir(id);
    }

}
