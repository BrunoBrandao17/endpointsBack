package com.example.endpoints.repository;

import com.example.endpoints.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNome(String nome);
}
