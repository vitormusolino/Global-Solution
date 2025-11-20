package com.fiap.neuro_mentor.service;

import com.fiap.neuro_mentor.domain.Usuario;
import com.fiap.neuro_mentor.dto.UsuarioDto;
import com.fiap.neuro_mentor.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    private UsuarioRepository repository;
    private UsuarioService service;

    @BeforeEach
    void setup() {
        repository = mock(UsuarioRepository.class);
        service = new UsuarioService(repository);
    }

    @Test
    void deveSalvarUsuario() {
        UsuarioDto dto = new UsuarioDto("Ana", "ana@email.com", "123456", "JOVEM");
        Usuario usuario = new Usuario(1L, "Ana", "ana@email.com", "123456", "JOVEM");

        when(repository.save(any())).thenReturn(usuario);

        Usuario resultado = service.salvar(dto);

        assertEquals("Ana", resultado.getNome());
        verify(repository).save(any());
    }

    @Test
    void deveListarUsuarios() {
        when(repository.findAll()).thenReturn(List.of(new Usuario(), new Usuario()));
        assertEquals(2, service.listar().size());
    }

    @Test
    void deveBuscarPorId() {
        Usuario usuario = new Usuario(1L, "Ana", "ana@email.com", "123456", "JOVEM");
        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario resultado = service.buscarPorId(1L);

        assertEquals("Ana", resultado.getNome());
    }

    @Test
    void deveExcluirUsuario() {
        doNothing().when(repository).deleteById(1L);

        service.excluir(1L);

        verify(repository).deleteById(1L);
    }
}
