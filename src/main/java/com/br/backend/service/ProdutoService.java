package com.br.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.backend.entity.Produto;
import com.br.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repo;

    public List<Produto> todosProdutos() {    
        return repo.findAll();        
    }

    public Produto novoProduto(Produto produto){
        return repo.save(produto); 
    }

}
