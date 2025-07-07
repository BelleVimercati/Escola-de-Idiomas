package com.sistema.projeto.repository;

import com.sistema.projeto.model.Gasto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {
      @Query("SELECT COALESCE(SUM(g.valor), 0) FROM Gasto g WHERE MONTH(g.data) = :mes AND YEAR(g.data) = :ano")
    double somarPorMesEAno(@Param("mes") int mes, @Param("ano") int ano);

    @Query("SELECT COALESCE(SUM(g.valor), 0) FROM Gasto g WHERE YEAR(g.data) = :ano")
    double somarPorAno(@Param("ano") int ano);
}
