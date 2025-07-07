package com.sistema.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.projeto.dto.RelatorioFinanceiroDTO;
import com.sistema.projeto.service.RelatorioFinanceiroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/relatorios")
public class RelatorioFinanceiroController {
    
    @Autowired
    private RelatorioFinanceiroService relatorioService;

    @GetMapping("/mensal")
    public ResponseEntity<?> gerarRelatorioMensal(@RequestParam int mes, @RequestParam int ano) {
        try {
            RelatorioFinanceiroDTO relatorio = relatorioService.gerarRelatorioMensal(mes, ano);
            return ResponseEntity.ok(relatorio);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/anual")
    public ResponseEntity<?> gerarRelatorioAnual(@RequestParam int ano) {
        try {
            RelatorioFinanceiroDTO relatorio = relatorioService.gerarRelatorioAnual(ano);
            return ResponseEntity.ok(relatorio);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
