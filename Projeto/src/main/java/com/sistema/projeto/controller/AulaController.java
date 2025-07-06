package com.sistema.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.projeto.model.Aula;
import com.sistema.projeto.service.AulaService;

@RestController
@RequestMapping("aulas")
public class AulaController {
    
    @Autowired
    private AulaService aulaService;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Aula aula, @RequestParam Long funcionarioId) {
        try {
            Aula salva = aulaService.salvarComPermissao(aula, funcionarioId);
            return ResponseEntity.ok(salva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Aula> listarTodas() {
        return aulaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> buscarPorId(@PathVariable Long id) {
        return aulaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Aula aula, @RequestParam Long funcionarioId) {
        try {
            Aula atualizada = aulaService.atualizarComPermissao(id, aula, funcionarioId);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id, @RequestParam Long funcionarioId) {
        try{
            aulaService.deletarComPermissao(id, funcionarioId);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
