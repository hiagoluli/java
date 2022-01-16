package com.farmacia.farmacia.Repositories;

import com.farmacia.farmacia.Models.usuarios;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<usuarios, String> {
    usuarios findByEmail(String email);
}
