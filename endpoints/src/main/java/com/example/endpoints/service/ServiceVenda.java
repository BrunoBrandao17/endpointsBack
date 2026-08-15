package com.example.endpoints.service;

import com.example.endpoints.model.ModelVenda;
import com.example.endpoints.repository.RepositoryVenda;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceVenda {

    private final RepositoryVenda repository;

    public ServiceVenda(RepositoryVenda repository) {
        this.repository = repository;
    }

    public List<ModelVenda> listar() {
        return repository.findAll();
    }

    public Optional<ModelVenda> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ModelVenda salvar(ModelVenda venda) {
        return repository.save(venda);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}