package com.farmacia.farmacia.Repositories;

import com.farmacia.farmacia.Models.produto;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
/*
public interface ProdutoRepository extends CrudRepository<produto, Long> {

    
}
*/

public interface ProdutoRepository extends JpaRepository<produto, Long> {
    
}
