package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/atualizarcadastro")
    public Usuario atualizar(Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }
    @PutMapping("/loginusuario")
    public Usuario login (@RequestBody Usuario usuario) {
        return  usuarioService.loginUsuario(usuario);
    }
}






