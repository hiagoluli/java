package com.farmacia.farmacia.Security;

import com.farmacia.farmacia.Models.usuarios;
import com.farmacia.farmacia.Repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        usuarios usuario = ur.findByEmail(email);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }
    
}
