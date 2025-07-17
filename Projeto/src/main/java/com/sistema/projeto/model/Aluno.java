package com.sistema.projeto.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Aluno extends Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int matricula;

    @ManyToMany
    @JsonBackReference
    @JoinTable(
        name = "aluno_turma",
        joinColumns = @JoinColumn(name = "aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "turma_id")
    )
    private List<Turma> turmas = new ArrayList<>();


    public Aluno(String nome, String endereco, String telefone, int matricula, String email, String senha) {
        super(nome, endereco, telefone, email, senha);
        this.matricula = matricula;
    }

    public Aluno() {
        super(); // necessário porque Usuario tem construtor com parâmetros
    }
    
    public Long getId() {
        return id;
    }    

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
