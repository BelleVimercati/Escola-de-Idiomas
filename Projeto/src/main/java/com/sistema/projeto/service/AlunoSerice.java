package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Aluno;
import com.sistema.projeto.model.Funcionario;
import com.sistema.projeto.model.enums.Cargo;
import com.sistema.projeto.repository.AlunoRepository;
import com.sistema.projeto.repository.FuncionarioRepository;

@Service
public class AlunoSerice {

    @Autowired //criando a ligação com repository
    private AlunoRepository alunoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Aluno salvarComPermissao(Aluno aluno, Long funcionarioId){
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem criar alunos.");
        }

        if(alunoRepository.findById((long) aluno.getMatricula()).isPresent()){
            throw new RuntimeException("Já existe um aluno com esta matricula.");
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }
    
    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    public void deletarComPermissao(Long alunoId, Long funcionarioId){
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem deletar alunos.");
        }

        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        alunoRepository.delete(aluno);
    }

    public Aluno atualizarComPermissao(Long id, Aluno dadosAtualizados, Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
                
        if (funcionario.getCargo() != Cargo.SECRETARIO) {
            throw new RuntimeException("Apenas funcionários com cargo SECRETARIO podem atualizar alunos.");
        }

        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

            aluno.setEmail(dadosAtualizados.getEmail());
            aluno.setMatricula(dadosAtualizados.getMatricula());
            aluno.setNome(dadosAtualizados.getNome());
            aluno.setEndereco(dadosAtualizados.getEndereco());
            aluno.setTelefone(dadosAtualizados.getTelefone());
            aluno.setTurmas(dadosAtualizados.getTurmas());

            return alunoRepository.save(aluno);
    }
}

