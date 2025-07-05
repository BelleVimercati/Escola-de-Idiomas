package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Turma;
import com.sistema.projeto.repository.TurmaRepository;

@Service
public class TurmaService {
    
    @Autowired
    private TurmaRepository turmaRepository;

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id);
    }
    
    public void deletar(Long id) {
        turmaRepository.deleteById(id);
    }
    
    public Turma atualizar(Long id, Turma turmaAtualizada) {
        return turmaRepository.findById(id).map(turma -> {
            turma.setIdioma(turmaAtualizada.getIdioma());
            turma.setNivel(turmaAtualizada.getNivel());
            turma.setInicio(turmaAtualizada.getInicio());
            turma.setFim(turmaAtualizada.getFim());
            turma.setData(turmaAtualizada.getData());
            return turmaRepository.save(turma);
        }).orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

}
