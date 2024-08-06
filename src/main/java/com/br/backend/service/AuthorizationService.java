package com.br.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.backend.repository.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService{

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        return repo.findByNome(nome);
    }
    
}
