package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Funcionario;
import com.sistema.projeto.model.Turma;
import com.sistema.projeto.model.enums.Cargo;
import com.sistema.projeto.repository.FuncionarioRepository;
import com.sistema.projeto.repository.TurmaRepository;

@Service
public class TurmaService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma salvarComPermissao(Turma turma, Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem criar turmas.");
        }

        if (turmaRepository.findByIdentificador(turma.getIdentificador()).isPresent()) {
            throw new RuntimeException("Já existe uma turma com este identificador.");
        }

        return turmaRepository.save(turma);
    }

    //Essa deixa de existir
    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id);
    }
    


/*     public void deletar(Long id) {
        turmaRepository.deleteById(id);
    } */

    public void deletarComPermissao(Long turmaId, Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    
        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem deletar turmas.");
        }
    
        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada."));
    
        turmaRepository.delete(turma);
    }
    
    
    public Turma atualizarComPermissao(Long id, Turma turmaAtualizada, Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    
        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem alterar turmas.");
        }
    
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    
        // Atualiza os campos permitidos
        turma.setIdioma(turmaAtualizada.getIdioma());
        turma.setNivel(turmaAtualizada.getNivel());
        turma.setInicio(turmaAtualizada.getInicio());
        turma.setFim(turmaAtualizada.getFim());
        turma.setData(turmaAtualizada.getData());
    
        return turmaRepository.save(turma);
    }
    

}
