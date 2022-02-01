package com.farmacia.farmacia.Repositories;

import java.util.List;

import com.farmacia.farmacia.Models.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.CrudRepository;
/*
public interface ProdutoRepository extends CrudRepository<produto, Long> {

    
}
*/
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<produto, Long> {
    
    @Query("SELECT id, descricao FROM produto where descricao like %:keyword%")
	public List<String> search(@Param("keyword") String keyword);
   
/*
    @Query("SELECT descricao FROM produto where descricao like %:keyword%")
    public List<produto> search(@Param("keyword") String keyword);
*/    
}
