package com.example.endpoints.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service

public class Service {

    @Autowired
    private Repository repository;

    // CADASTRAR
    public Model cadastrar(Model cliente) {
        return repository.save(cliente);
    }

    // LISTAR TODOS
    public List<Model> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Model buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));
    }

    // ATUALIZAR
    public Model atualizar(Long id, Model dados) {

        Model cliente = buscarPorId(id);

        cliente.setNome(dados.getNome());
        cliente.setEmail(dados.getEmail());
        cliente.setTelefone(dados.getTelefone());

        return repository.save(cliente);
    }

    // DELETAR
    public void deletar(Long id) {

        Model cliente = buscarPorId(id);

        repository.delete(cliente);
    }
}