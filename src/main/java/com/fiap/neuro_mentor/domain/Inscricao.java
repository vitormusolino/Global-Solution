package com.fiap.neuro_mentor.domain;

import jakarta.persistence.*;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long trilhaId;

    public Inscricao() {}

    public Inscricao(Long id, Long usuarioId, Long trilhaId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.trilhaId = trilhaId;
    }

    public Long getId() { return id; }
    public Long getUsuarioId() { return usuarioId; }
    public Long getTrilhaId() { return trilhaId; }

    public void setId(Long id) { this.id = id; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public void setTrilhaId(Long trilhaId) { this.trilhaId = trilhaId; }
}
