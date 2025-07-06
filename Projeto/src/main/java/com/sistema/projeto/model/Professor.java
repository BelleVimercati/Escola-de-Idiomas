package com.sistema.projeto.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int matricula;

    @Column(nullable = false, unique = true)
    private int salario;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private List<Aula> aulas = new ArrayList<>();

    public Professor() {
        super(); // necessário porque Usuario tem construtor com parâmetros
    }

    public Professor(String nome, String endereco, String telefone, int matricula, String email) {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
}
