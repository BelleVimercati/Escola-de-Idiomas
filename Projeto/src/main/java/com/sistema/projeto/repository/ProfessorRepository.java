package com.sistema.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.projeto.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}