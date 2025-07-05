package com.sistema.projeto.controller;

import java.util.List;
import java.util.Optional;

import com.sistema.projeto.model.Aluno;

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

import com.sistema.projeto.service.AlunoSerice;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoSerice alunoService;

    @GetMapping
    public List<Aluno> listar(){
        return alunoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno){
        Aluno novoAluno = alunoService.salvar(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.buscarPorId(id);
        return aluno.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        try {
            Aluno atualizado = alunoService.atualizar(id, aluno);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
