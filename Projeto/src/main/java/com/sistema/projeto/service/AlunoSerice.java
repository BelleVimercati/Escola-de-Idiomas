package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Aluno;
import com.sistema.projeto.repository.AlunoRepository;

@Service
public class AlunoSerice {

    @Autowired //criando a ligação com repository
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){
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

    public Aluno atualizar(Long id, Aluno dadosAtualizados) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setEmail(dadosAtualizados.getEmail());
            aluno.setMatricula(dadosAtualizados.getMatricula());
            aluno.setNome(dadosAtualizados.getNome());
            aluno.setEndereco(dadosAtualizados.getEndereco());
            aluno.setTelefone(dadosAtualizados.getTelefone());
            aluno.setTurmas(dadosAtualizados.getTurmas());
            return alunoRepository.save(aluno);
        }).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
}
