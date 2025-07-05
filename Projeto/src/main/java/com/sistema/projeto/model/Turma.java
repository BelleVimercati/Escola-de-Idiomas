package com.sistema.projeto.model;
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

    /* Turma tem uma lista de alunos */
    @ManyToMany(mappedBy = "turmas")
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(mappedBy = "turma")
    private List<Aula> aulas = new ArrayList<>();



    // Ajustar
    public Turma(Idioma idioma, Nivel nivel, LocalDateTime inicio, LocalDateTime fim, LocalDate data) {
        this.idioma = idioma;
        this.nivel = nivel;
        this.inicio = inicio;
        this.fim = fim;
        this.data = data;
    }

    public Turma() {
    
    }

    public Long getId() {
        return id;
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

    
}
