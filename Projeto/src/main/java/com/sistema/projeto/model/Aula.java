package com.sistema.projeto.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Aula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_inicio")
    private LocalDateTime inicio;

    @Column(name = "data_hora_fim")
    private LocalDateTime fim;
    
    @Column(name = "data")
    private LocalDate data; 

    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name="turma_id")
    private Turma turma;


    // Ajustar a questão de data aqui
    public Aula(LocalDateTime inicio, LocalDateTime fim, LocalDate data) {
        this.inicio = inicio;
        this.fim = fim;
        this.data = data;
    }

    public Aula() {
    }

    public Long getId() {
        return id;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    

}
