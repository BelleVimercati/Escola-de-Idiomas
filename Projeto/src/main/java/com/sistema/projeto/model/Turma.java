package com.sistema.projeto.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.projeto.model.enums.Idioma;
import com.sistema.projeto.model.enums.Nivel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identificador", nullable = false)
    private String identificador;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Column(name = "data_hora_inicio")
    private LocalDateTime inicio;

    @Column(name = "data_hora_fim")
    private LocalDateTime fim;
    
    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Float valor;

    /* Turma tem uma lista de alunos */
    @ManyToMany(mappedBy = "turmas")
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(mappedBy = "turma")
    @JsonIgnore
    private List<Aula> aulas = new ArrayList<>();

    // Ajustar
    public Turma(Idioma idioma, Nivel nivel, LocalDateTime inicio, LocalDateTime fim, LocalDate data, String identificador) {
        this.idioma = idioma;
        this.nivel = nivel;
        this.inicio = inicio;
        this.fim = fim;
        this.data = data;
        this.identificador = identificador;
    }

    public Turma() {
    
    }

    public Long getId() {
        return id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Idioma getIdioma() {
        return idioma;
    }


    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }


    public Nivel getNivel() {
        return nivel;
    }


    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }


    public LocalDateTime getInicio() {
        return inicio;
    }


    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }


    public LocalDateTime getFim() {
        return fim;
    }


    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    } 

        // equals e hashCode baseados no id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma)) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    
}
