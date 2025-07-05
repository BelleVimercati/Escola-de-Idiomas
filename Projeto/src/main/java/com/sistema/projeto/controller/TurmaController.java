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
import org.springframework.web.bind.annotation.RestController;

import com.sistema.projeto.model.Turma;
import com.sistema.projeto.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public Turma criar(@RequestBody Turma turma) {
        return turmaService.salvar(turma);
    }

    @GetMapping
    public List<Turma> listar() {
        return turmaService.listarTodas();
    }

     @GetMapping("/{id}")
    public ResponseEntity<Turma> buscar(@PathVariable Long id) {
        return turmaService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    } 

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizar(@PathVariable Long id, @RequestBody Turma turma) {
        try {
            Turma atualizada = turmaService.atualizar(id, turma);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        turmaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
