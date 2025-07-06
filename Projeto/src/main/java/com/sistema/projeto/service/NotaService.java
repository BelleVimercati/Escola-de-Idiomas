package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Nota;
import com.sistema.projeto.model.NotaDTO;
import com.sistema.projeto.model.Turma;
import com.sistema.projeto.model.Aluno;
import com.sistema.projeto.repository.AlunoRepository;
import com.sistema.projeto.repository.NotaRepository;
import com.sistema.projeto.repository.TurmaRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;


    public Nota registrarNota(NotaDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                         .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    
        Turma turma = turmaRepository.findById(dto.getTurmaId())
                         .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    
        Nota nota = new Nota();
        nota.setAluno(aluno);
        nota.setTurma(turma);
        nota.setValor(dto.getValor());
        nota.setDescricao(dto.getDescricao());
    
        return notaRepository.save(nota);
    }


    public List<Nota> listarNotasPorAluno(Long alunoId) {
        return notaRepository.findByAlunoId(alunoId);
    }

    public List<Nota> listarNotasPorTurma(Long turmaId) {
        return notaRepository.findByTurmaId(turmaId);
    }

    public Optional<Nota> buscarPorId(Long id) {
        return notaRepository.findById(id);
    }
}
