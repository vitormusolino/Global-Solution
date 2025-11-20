package com.fiap.neuro_mentor.controller;

import com.fiap.neuro_mentor.domain.Trilha;
import com.fiap.neuro_mentor.dto.TrilhaDto;
import com.fiap.neuro_mentor.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Trilha> criar(@RequestBody @Valid TrilhaDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Trilha>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizar(@PathVariable Long id, @RequestBody @Valid TrilhaDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
