package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Aula;
import com.sistema.projeto.repository.AulaRepository;

@Service
public class AulaService {
    
    @Autowired
    private AulaRepository aulaRepository;

    public Aula salvar(Aula aula) {
        return aulaRepository.save(aula);
    }

    public List<Aula> listarTodas() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> buscarPorId(Long id) {
        return aulaRepository.findById(id);
    }

    public Aula atualizar(Long id, Aula novaAula) {
        return aulaRepository.findById(id).map(aula -> {
            aula.setInicio(novaAula.getInicio());
            aula.setFim(novaAula.getFim());
            aula.setData(novaAula.getData());
            aula.setValor(novaAula.getValor());
            aula.setProfessor(novaAula.getProfessor());
            aula.setTurma(novaAula.getTurma());
            return aulaRepository.save(aula);
        }).orElseThrow(() -> new RuntimeException("Aula não encontrada"));
    }

    public void deletar(Long id) {
        aulaRepository.deleteById(id);
    }
}
