package com.example.endpoints.controller;

import com.example.endpoints.model.ModelVenda;
import com.example.endpoints.service.ServiceVenda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class ControllerVenda {

    private final ServiceVenda service;

    public ControllerVenda(ServiceVenda service) {
        this.service = service;
    }

    @GetMapping
    public List<ModelVenda> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelVenda> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ModelVenda criar(@RequestBody ModelVenda venda) {
        return service.salvar(venda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelVenda> atualizar(
            @PathVariable Long id,
            @RequestBody ModelVenda venda) {

        return service.buscarPorId(id)
                .map(vendaExistente -> {
                    venda.setId(id);
                    return ResponseEntity.ok(service.salvar(venda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}