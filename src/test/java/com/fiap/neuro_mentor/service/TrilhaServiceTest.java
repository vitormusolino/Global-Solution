package com.fiap.neuro_mentor.service;

import com.fiap.neuro_mentor.domain.Trilha;
import com.fiap.neuro_mentor.dto.TrilhaDto;
import com.fiap.neuro_mentor.repository.TrilhaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrilhaServiceTest {

    private TrilhaRepository repository;
    private TrilhaService service;

    @BeforeEach
    void setup() {
        repository = mock(TrilhaRepository.class);
        service = new TrilhaService(repository);
    }

    @Test
    void deveSalvarTrilha() {
        TrilhaDto dto = new TrilhaDto("Java", "Back-end", 40, "Intermediário");

        Trilha trilha = new Trilha(1L, "Java", "Back-end", 40, "Intermediário");

        when(repository.save(any())).thenReturn(trilha);

        Trilha resultado = service.salvar(dto);

        assertEquals("Java", resultado.getTitulo());
        verify(repository).save(any());
    }

    @Test
    void deveListarTrilhas() {
        when(repository.findAll()).thenReturn(List.of(new Trilha(), new Trilha()));
        assertEquals(2, service.listar().size());
    }

    @Test
    void deveBuscarPorId() {
        Trilha trilha = new Trilha();
        trilha.setId(1L);
        trilha.setTitulo("Java");

        when(repository.findById(1L)).thenReturn(Optional.of(trilha));

        Trilha resultado = service.buscarPorId(1L);
        assertEquals("Java", resultado.getTitulo());
    }

    @Test
    void deveExcluirTrilha() {
        doNothing().when(repository).deleteById(1L);
        service.excluir(1L);
        verify(repository).deleteById(1L);
    }
}
