package com.fiap.neuro_mentor.service;

import com.fiap.neuro_mentor.domain.Usuario;
import com.fiap.neuro_mentor.dto.UsuarioDto;
import com.fiap.neuro_mentor.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(UsuarioDto dto) {
        Usuario usuario = new Usuario(null, dto.nome(), dto.email(), dto.senha(), dto.perfil());
        return repository.save(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Usuario atualizar(Long id, UsuarioDto dto) {
        Usuario existente = buscarPorId(id);
        existente.setNome(dto.nome());
        existente.setEmail(dto.email());
        existente.setSenha(dto.senha());
        existente.setPerfil(dto.perfil());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
