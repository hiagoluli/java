package com.farmacia.farmacia.Repositories;

import java.util.List;

import com.farmacia.farmacia.Models.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<produto, Long> {
   
    @Query("SELECT id, descricao FROM produto where descricao like %:keyword%")
    public List<produto> buscaPorDescricao(@Param("keyword") String keyword);

    @Query("SELECT p FROM produto p where p.categoria = ?1")
    public Page<produto> findAllByCategoria(String sortField, Pageable pageable);

    
}
