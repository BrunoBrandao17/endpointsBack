package com.example.endpoints.service;

import com.example.endpoints.model.FuncionarioModel;
import com.example.endpoints.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioModel> listarTodos() {
        return repository.findAll();
    }

    public FuncionarioModel salvarFuncionario(FuncionarioModel funcionario) {
        if (repository.findByMatricula(funcionario.getMatricula()).isPresent()) {
            throw new RuntimeException("Funcionário já cadastrado com esta matrícula");
        }

        return repository.save(funcionario);
    }

    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioModel funcionario) {
        FuncionarioModel funcionarioExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Optional<FuncionarioModel> funcionarioComMatricula = repository.findByMatricula(funcionario.getMatricula());
        if (funcionarioComMatricula.isPresent() && !Objects.equals(funcionarioComMatricula.get().getId(), id)) {
            throw new RuntimeException("Esta matrícula já está em uso por outro funcionário");
        }

        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setMatricula(funcionario.getMatricula());
        funcionarioExistente.setCargo(funcionario.getCargo());

        return repository.save(funcionarioExistente);
    }

    public void deletarFuncionario(Long id) {
        FuncionarioModel funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        repository.delete(funcionario);
    }
}