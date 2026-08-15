package com.example.endpoints.service;

import com.example.endpoints.model.ProdutoModel;
import com.example.endpoints.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

  public List<ProdutoModel> listar(){
      return repository.findAll();
    }

    public ProdutoModel cadastrar(ProdutoModel produto){
      return repository.save(produto);
    }

    public ProdutoModel buscarPorNome(String nome){
      return repository.findByNome(nome)
              .orElseThrow(() ->
                      new RuntimeException("Produto não encontrado"));
    }

    public ProdutoModel atualizar(String nome, ProdutoModel dados) {
        ProdutoModel produto = buscarPorNome(nome);

        produto.setNome(dados.getNome());
        produto.setQuantidade(dados.getQuantidade());
        produto.setPreco(dados.getPreco());

        return repository.save(produto);
    }

    public void deletar(String nome){
      ProdutoModel produto = buscarPorNome(nome);
    }

}
