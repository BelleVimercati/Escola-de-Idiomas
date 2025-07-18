package com.sistema.projeto.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gasto {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private String descricao;
    
    @Column(name = "data_registro", nullable = false)
    private LocalDate data = LocalDate.now();

    
    public Gasto(Float valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = LocalDate.now();
    }

    public Gasto() {}

    public Long getId() {
        return id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }
}
