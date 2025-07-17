package com.sistema.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Funcionario;
import com.sistema.projeto.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario atualizar(Long id, Funcionario atualizado) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(atualizado.getNome());
            funcionario.setEndereco(atualizado.getEndereco());
            funcionario.setTelefone(atualizado.getTelefone());
            funcionario.setSalario(atualizado.getSalario());
            funcionario.setCargo(atualizado.getCargo());
            funcionario.setSenha(atualizado.getSenha());
            funcionario.setEmail(atualizado.getEmail());
            return funcionarioRepository.save(funcionario);
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
