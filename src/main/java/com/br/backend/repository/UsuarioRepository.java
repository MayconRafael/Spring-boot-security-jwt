package com.br.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario>findById(Long id);

    UserDetails findByNome(String nome);

}
