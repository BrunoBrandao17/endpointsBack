package com.example.endpoints.controller;

import com.example.endpoints.model.FuncionarioModel;
import com.example.endpoints.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> criar(@Valid @RequestBody FuncionarioModel funcionario) {
        FuncionarioModel novoFuncionario = service.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody FuncionarioModel funcionario) {
        return ResponseEntity.ok(service.atualizarFuncionario(id, funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}