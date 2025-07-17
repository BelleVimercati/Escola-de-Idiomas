package com.sistema.projeto.model;
import com.sistema.projeto.model.enums.Cargo;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float salario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Funcionario() {
        super(); // necessário porque Usuario tem construtor com parâmetros
    }
    
    public Funcionario(String nome, String endereco, String telefone, Float salario, Cargo cargo, String email, String senha) {
        super(nome, endereco, telefone, email, senha);
        this.salario = salario;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    
}
