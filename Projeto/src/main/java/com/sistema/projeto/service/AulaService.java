package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.projeto.model.Aula;
import com.sistema.projeto.model.Funcionario;
import com.sistema.projeto.model.enums.Cargo;
import com.sistema.projeto.repository.AulaRepository;
import com.sistema.projeto.repository.FuncionarioRepository;

@Service
public class AulaService {
    
    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Aula salvarComPermissao(Aula aula, Long funcionarioId){
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem criar aulas.");
        }

        return aulaRepository.save(aula);
    }

    public List<Aula> listarTodas() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> buscarPorId(Long id) {
        return aulaRepository.findById(id);
    }

    public Aula atualizarComPermissao(Long id, Aula novaAula, Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrada"));
                
        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem atualizar aulas.");
        }

        Aula aula = aulaRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula não encontrado"));

            aula.setInicio(novaAula.getInicio());
            aula.setFim(novaAula.getFim());
            aula.setData(novaAula.getData());
            aula.setProfessor(novaAula.getProfessor());
            aula.setTurma(novaAula.getTurma());


            return aulaRepository.save(aula);
    }

    public void deletarComPermissao(Long aulaId, Long funcionarioId){
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem deletar aulas.");
        }

        Aula aula = aulaRepository.findById(aulaId).orElseThrow(() -> new RuntimeException("Aula não encontrado."));

        aulaRepository.delete(aula);
    }
}
