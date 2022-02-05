package com.farmacia.farmacia.Repositories;

import java.util.List;
import java.util.Optional;

import com.farmacia.farmacia.Models.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<produto, Long> {
   
    @Query("SELECT id, descricao FROM produto where descricao like %:keyword%")
    public List<produto> buscaPorDescricao(@Param("keyword") String keyword);

    @Query("SELECT p FROM produto p where p.categoria like %:categoria%")
    public List<produto> buscaPorCategoria(@Param("categoria") String categoria);
    
}
