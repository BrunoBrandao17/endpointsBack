package com.example.endpoints.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping
    public Model cadastrar(@RequestBody Model cliente) {
        return service.cadastrar(cliente);
    }

    @GetMapping
    public List<Model> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Model buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Model atualizar(
            @PathVariable Long id,
            @RequestBody Model cliente) {

        return service.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}