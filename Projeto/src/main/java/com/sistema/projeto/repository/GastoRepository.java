package com.sistema.projeto.repository;

import com.sistema.projeto.model.Gasto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {
    
}
