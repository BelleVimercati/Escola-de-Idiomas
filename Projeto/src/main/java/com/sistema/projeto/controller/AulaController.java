package com.sistema.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.projeto.model.Aula;
import com.sistema.projeto.service.AulaService;

@Controller
@RequestMapping("aulas")
public class AulaController {
    
    @Autowired
    private AulaService aulaService;

    @PostMapping
    public Aula criar(@RequestBody Aula aula) {
        return aulaService.salvar(aula);
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
    public ResponseEntity<Aula> atualizar(@PathVariable Long id, @RequestBody Aula aula) {
        try {
            Aula atualizada = aulaService.atualizar(id, aula);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        aulaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
