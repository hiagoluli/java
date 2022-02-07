package com.farmacia.farmacia.Services;

import java.util.List;

import com.farmacia.farmacia.Models.Categoria;
import com.farmacia.farmacia.Repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class categoriaService {
    
    @Autowired
    private CategoriaRepository cr;
    
    public List<Categoria> listAll() {
        return cr.findAll();
    }
    
}
