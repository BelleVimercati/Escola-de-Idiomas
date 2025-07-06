package com.sistema.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.projeto.model.Nota;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlunoId(Long alunoId);
    List<Nota> findByTurmaId(Long turmaId);
    List<Nota> findByAlunoIdAndTurmaId(Long alunoId, Long turmaId);
}
