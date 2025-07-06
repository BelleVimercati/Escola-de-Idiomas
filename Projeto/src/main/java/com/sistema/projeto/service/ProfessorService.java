package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Professor;
import com.sistema.projeto.repository.ProfessorRepository;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public Professor atualizar(Long id, Professor atualizado) {
        return professorRepository.findById(id).map(professor -> {
            professor.setMatricula(atualizado.getMatricula());
            professor.setEmail(atualizado.getEmail());
            professor.setNome(atualizado.getNome());
            professor.setEndereco(atualizado.getEndereco());
            professor.setTelefone(atualizado.getTelefone());
            professor.setSalario(atualizado.getSalario());
            return professorRepository.save(professor);
        }).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }
}
