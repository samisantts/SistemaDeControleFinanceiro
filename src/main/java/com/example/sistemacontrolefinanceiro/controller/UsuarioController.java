package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {


    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }
     @PostMapping ("/usuarios")
    public Usuario cadastrar(Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }
        }





