package com.farmacia.farmacia.Repositories;

import com.farmacia.farmacia.Models.produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<produto, String> {

    
}
