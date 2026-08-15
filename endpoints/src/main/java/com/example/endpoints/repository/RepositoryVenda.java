package com.example.endpoints.repository;

import com.example.endpoints.model.ModelVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVenda extends JpaRepository<ModelVenda, Long> {
}