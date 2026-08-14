package com.example.endpoints.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_funcionarios")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres")
    private String nome;

    @NotBlank(message = "A matrícula é obrigatória")
    private String matricula;

    @NotBlank(message = "O cargo é obrigatório")
    private String cargo;

    public FuncionarioModel() {
    }

    public FuncionarioModel(Long id, String nome, String matricula, String cargo) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}