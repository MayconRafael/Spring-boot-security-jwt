package com.br.backend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.backend.entity.Produto;
import com.br.backend.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        List<Produto> resposta = service.todosProdutos();
        return ResponseEntity.ok(resposta);
    }

    @PostMapping
    public ResponseEntity<Void> novoProduto(@RequestBody Produto produto, UriComponentsBuilder ucb) {
        Produto produtoCadastrado = service.novoProduto(produto);   
        URI localizacaoDoNovoProduto = ucb
                .path("produto/{id}")
                .buildAndExpand(produtoCadastrado.getId())
                .toUri();     
        return ResponseEntity.created(localizacaoDoNovoProduto).build(); 
    }

}
