package com.fiap.neuro_mentor.domain;

import jakarta.persistence.*;

@Entity
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String categoria;
    private Integer cargaHoraria;
    private String nivel;

    public Trilha() {}

    public Trilha(Long id, String titulo, String categoria, Integer cargaHoraria, String nivel) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.cargaHoraria = cargaHoraria;
        this.nivel = nivel;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getCategoria() { return categoria; }
    public Integer getCargaHoraria() { return cargaHoraria; }
    public String getNivel() { return nivel; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}
