package com.fiap.neuro_mentor.service;

import com.fiap.neuro_mentor.domain.Inscricao;
import com.fiap.neuro_mentor.dto.InscricaoDto;
import com.fiap.neuro_mentor.repository.InscricaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InscricaoServiceTest {

    private InscricaoRepository repository;
    private InscricaoService service;

    @BeforeEach
    void setup() {
        repository = mock(InscricaoRepository.class);
        service = new InscricaoService(repository);
    }

    @Test
    void deveSalvarInscricao() {
        InscricaoDto dto = new InscricaoDto(1L, 2L);

        Inscricao inscricao = new Inscricao();
        inscricao.setId(1L);
        inscricao.setUsuarioId(dto.usuarioId());
        inscricao.setTrilhaId(dto.trilhaId());

        when(repository.save(any())).thenReturn(inscricao);

        Inscricao resultado = service.salvar(dto);

        assertEquals(1L, resultado.getUsuarioId());
        verify(repository).save(any());
    }

    @Test
    void deveListarInscricoes() {
        when(repository.findAll()).thenReturn(List.of(new Inscricao(), new Inscricao()));
        assertEquals(2, service.listar().size());
    }

    @Test
    void deveBuscarPorId() {
        Inscricao inscricao = new Inscricao();
        inscricao.setId(1L);
        inscricao.setUsuarioId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(inscricao));

        Inscricao resultado = service.buscarPorId(1L);
        assertEquals(1L, resultado.getUsuarioId());
    }

    @Test
    void deveExcluirInscricao() {
        doNothing().when(repository).deleteById(1L);
        service.excluir(1L);
        verify(repository).deleteById(1L);
    }
}
