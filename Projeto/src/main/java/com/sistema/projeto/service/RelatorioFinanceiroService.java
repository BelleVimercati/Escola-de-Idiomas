package com.sistema.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.projeto.builder.RelatorioFinanceiroBuilder;
import com.sistema.projeto.dto.RelatorioFinanceiroDTO;
import com.sistema.projeto.model.Funcionario;
import com.sistema.projeto.model.Professor;
import com.sistema.projeto.repository.FuncionarioRepository;
import com.sistema.projeto.repository.GastoRepository;
import com.sistema.projeto.repository.ProfessorRepository;
import com.sistema.projeto.repository.TurmaRepository;

@Service
public class RelatorioFinanceiroService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public RelatorioFinanceiroDTO gerarRelatorioMensal(int mes, int ano) {
        double gastos = gastoRepository.somarPorMesEAno(mes, ano);

        double gastoPrevistoFuncionarios = funcionarioRepository.findAll()
            .stream()
            .mapToDouble(t -> t.getSalario())
            .sum();

        double gastoPrevistoProfessores = professorRepository.findAll()
            .stream()
            .mapToDouble(t -> t.getSalario())
            .sum();

        double gastoPrevisto = (gastoPrevistoFuncionarios + gastoPrevistoProfessores);

        double arrecadado = turmaRepository.findAll()
            .stream()
            .mapToDouble(t -> t.getValor() * t.getAlunos().size())
            .sum();

        return new RelatorioFinanceiroBuilder()
                .comMes(mes)
                .comAno(ano)
                .comGastoRealizado(gastos)
                .comGastoPrevisto(gastoPrevisto)
                .comValorArrecadado(arrecadado)
                .build();
    }

    public RelatorioFinanceiroDTO gerarRelatorioAnual(int ano) {
        double gastos = gastoRepository.somarPorAno(ano);

         double gastoPrevistoFuncionarios = funcionarioRepository.findAll()
        .stream()
        .mapToDouble(Funcionario::getSalario)
        .sum();

        double gastoPrevistoProfessores = professorRepository.findAll()
            .stream()
            .mapToDouble(Professor::getSalario)
            .sum();

        double gastoPrevisto = (gastoPrevistoFuncionarios + gastoPrevistoProfessores) * 12;
        
        double arrecadado = turmaRepository.findAll()
            .stream()
            .mapToDouble(t -> t.getValor() * t.getAlunos().size())
            .sum() * 12;

        return new RelatorioFinanceiroBuilder()
                .comAno(ano)
                .comGastoRealizado(gastos)
                .comGastoPrevisto(gastoPrevisto)
                .comValorArrecadado(arrecadado)
                .build();
    }
}

