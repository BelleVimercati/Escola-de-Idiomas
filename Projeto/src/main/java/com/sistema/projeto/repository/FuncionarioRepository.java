package com.sistema.projeto.repository;

import com.sistema.projeto.model.Funcionario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
        Optional<Funcionario> findByEmail(String email);
}
