package com.br.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.backend.entity.AuthenticationDTO;
import com.br.backend.entity.LoginReponseDTO;
import com.br.backend.entity.RegisterDTO;
import com.br.backend.entity.Usuario;
import com.br.backend.repository.UsuarioRepository;
import com.br.backend.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private TokenService tokenService;
    

    @PostMapping("/login")
    public ResponseEntity<LoginReponseDTO> login(@RequestBody @Valid AuthenticationDTO data){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        var auth = this.authenticationManager.authenticate(usuarioSenha);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginReponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data){
        if(this.repo.findByNome(data.nome()) != null) return ResponseEntity.badRequest().build();

        String senhaEncriptada = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novoUsuario = new Usuario(data.nome(), senhaEncriptada, data.cargo());

        this.repo.save(novoUsuario);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Usuario>> listAll(){
        List<Usuario> resposta = this.repo.findAll();
        return ResponseEntity.ok(resposta);
    }

}
