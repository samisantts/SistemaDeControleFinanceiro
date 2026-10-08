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
    @PostMapping("/usuarios")
    public Usuario cadastrar(@RequestBody Usuario usuario) {

        return usuarioService.cadastrarUsuario(usuario);
    }
    @PostMapping("/atualizarcadastro")
    public Usuario atualizar(@RequestBody Usuario usuario) {

        return usuarioService.atualizarUsuario(usuario);
    }
    @PutMapping("/loginusuario")
    public Usuario login(@RequestBody Usuario usuario) {

        return usuarioService.loginUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletar(@PathVariable long id) {

    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {

        return usuarioService.listarUsuarioPorId(id);
    }
}






