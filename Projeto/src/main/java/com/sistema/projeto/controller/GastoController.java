package com.sistema.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.projeto.model.Gasto;
import com.sistema.projeto.service.GastoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("gastos")
public class GastoController {
    
    @Autowired
    private GastoService gastoService;

    @GetMapping
    public List<Gasto> listar() {
        return gastoService.listarTodos();
    }
    
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Gasto gasto, @RequestParam Long funcionarioId) {
        try {
            System.out.println("Funcionario ID recebido: " + funcionarioId);
            Gasto salva = gastoService.salvarComPermissao(gasto, funcionarioId);
            return ResponseEntity.ok(salva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Gasto gasto, @RequestParam Long funcionarioId) {
        try {
            Gasto atualizada = gastoService.atualizarComPermissao(id, gasto, funcionarioId);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id, @RequestParam Long funcionarioId) {
        try{
            gastoService.deletarComPermissao(id, funcionarioId);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
