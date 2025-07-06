package com.sistema.projeto.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nota pertence a um Aluno
    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id")
    @JsonIgnore
    private Aluno aluno;

    // Nota pertence a uma Turma
    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id")
    @JsonIgnore
    private Turma turma;

    // Valor da nota
    @Column(nullable = false)
    private Double valor;

    @Column
    private String descricao;

    @Column
    private LocalDate dataRegistro = LocalDate.now();

    public Nota() {}

    public Nota(Aluno aluno, Turma turma, Double valor, String descricao) {
        this.aluno = aluno;
        this.turma = turma;
        this.valor = valor;
        this.descricao = descricao;
        this.dataRegistro = LocalDate.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
}
