package com.farmacia.farmacia.Services;

import java.util.List;
import com.farmacia.farmacia.Models.produto;
import com.farmacia.farmacia.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class produtoService {

    //@Autowired
    //private ProdutoRepository pr;

    private final ProdutoRepository pr;
    
    public List<produto> listAll() {
        return pr.findAll();
    }

    
    public produto findById(long id) {
        return pr.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));
    }
    
}