package com.sistema.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.projeto.model.Nota;
import com.sistema.projeto.service.NotaService;
import com.sistema.projeto.model.NotaDTO;


import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    // Registrar nota
    @PostMapping
    public ResponseEntity<Nota> registrarNota(@RequestBody NotaDTO nota) {
        Nota novaNota = notaService.registrarNota(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNota);
    }

    // Listar notas de um aluno
    @GetMapping("/aluno/{alunoId}")
    public List<Nota> listarNotasAluno(@PathVariable Long alunoId) {
        return notaService.listarNotasPorAluno(alunoId);
    }

    // Listar notas de uma turma
    @GetMapping("/turma/{turmaId}")
    public List<Nota> listarNotasTurma(@PathVariable Long turmaId) {
        return notaService.listarNotasPorTurma(turmaId);
    }
}


