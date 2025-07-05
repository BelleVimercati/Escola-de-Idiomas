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

import com.sistema.projeto.model.Professor;
import com.sistema.projeto.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
     @Autowired
    private ProfessorService professorService;

    @PostMapping
    public Professor criar(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    @GetMapping
    public List<Professor> listar() {
        return professorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscar(@PathVariable Long id) {
        return professorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor professor) {
        try {
            Professor atualizado = professorService.atualizar(id, professor);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        professorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
