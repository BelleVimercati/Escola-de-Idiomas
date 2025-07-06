package com.sistema.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.model.Funcionario;
import com.sistema.projeto.model.Gasto;
import com.sistema.projeto.model.enums.Cargo;
import com.sistema.projeto.repository.FuncionarioRepository;
import com.sistema.projeto.repository.GastoRepository;

@Service    
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Gasto salvarComPermissao(Gasto gasto, Long funcionarioId){
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (funcionario.getCargo() != Cargo.GERENTE) {
            throw new RuntimeException("Apenas funcionários com cargo GERENTE podem criar aulas.");
        }

        return gastoRepository.save(gasto);
    }   
    
    public List<Gasto> listarTodos(){
        return gastoRepository.findAll();
    }

        public void deletarComPermissao(Long gastoId, Long funcionarioId){
            Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                    .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

            if (funcionario.getCargo() != Cargo.GERENTE) {
                throw new RuntimeException("Apenas funcionários com cargo GERENTE podem deletar aulas.");
            }

            Gasto gasto = gastoRepository.findById(gastoId).orElseThrow(() -> new RuntimeException("Aula não encontrado."));

            gastoRepository.delete(gasto);
    }

    public Gasto atualizarComPermissao(Long id, Gasto novoGasto, Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
                
        if (funcionario.getCargo() != Cargo.GERENTE) {
            throw new RuntimeException("Apenas funcionários com cargo GERENTE podem atualizar gastos.");
        }

        Gasto gasto = gastoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula não encontrado"));

            gasto.setDescricao(novoGasto.getDescricao());
            gasto.setValor(novoGasto.getValor());

            return gastoRepository.save(gasto);
    }

}
