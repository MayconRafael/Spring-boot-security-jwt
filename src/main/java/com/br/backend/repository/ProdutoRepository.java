package com.br.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
