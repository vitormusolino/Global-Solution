package com.fiap.neuro_mentor.controller;

import com.fiap.neuro_mentor.domain.Inscricao;
import com.fiap.neuro_mentor.dto.InscricaoDto;
import com.fiap.neuro_mentor.service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

    private final InscricaoService service;

    public InscricaoController(InscricaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Inscricao> inscrever(@RequestBody @Valid InscricaoDto dto) {
        return ResponseEntity.ok(service.inscrever(dto));
    }

    @GetMapping
    public ResponseEntity<List<Inscricao>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        service.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}
