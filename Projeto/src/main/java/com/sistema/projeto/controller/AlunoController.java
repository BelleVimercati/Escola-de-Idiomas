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
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> criar(@RequestBody Aluno aluno, @RequestParam Long funcionarioId){
        try {
            Aluno salva = alunoService.salvarComPermissao(aluno, funcionarioId);
            return ResponseEntity.ok(salva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.buscarPorId(id);
        return aluno.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Aluno aluno, @RequestParam Long funcionarioId) {
        try {
            Aluno atualizado = alunoService.atualizarComPermissao(id, aluno, funcionarioId);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id, @RequestParam Long funcionarioId) {
        try {
            alunoService.deletarComPermissao(id, funcionarioId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{alunoId}/adicionar-turma")
    public ResponseEntity<?> adicionarTurmaParaAluno(
            @PathVariable Long alunoId,
            @RequestParam Long turmaId,
            @RequestParam Long funcionarioId) {
        try {
            Aluno atualizado = alunoService.adicionarTurmaParaAluno(funcionarioId, alunoId, turmaId);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
