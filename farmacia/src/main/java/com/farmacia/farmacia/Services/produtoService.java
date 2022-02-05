package com.farmacia.farmacia.Services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class produtoService {

    @Autowired
    private ProdutoRepository pr;
    
    public List<produto> listAll() {
        return pr.findAll();
    }

    public List<produto> listAllByCategory(String categoria) {
        return pr.buscaPorCategoria(categoria);
    }
    
    public produto findById(long id) {
        return pr.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));
    }

    public List<produto> buscaPorDescricao(String keyword) {
        return pr.buscaPorDescricao(keyword);
    }

    public produto salvarProduto(produto prod){
        return pr.save(prod);
    }

    public void excluirProduto(Long id){
        pr.deleteById(id);
    }

    public class ResourceNotFoundException extends RuntimeException { }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "/cadastrarProduto";
    }

}
