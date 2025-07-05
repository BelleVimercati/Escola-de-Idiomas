package com.sistema.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.projeto.model.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long> {
}