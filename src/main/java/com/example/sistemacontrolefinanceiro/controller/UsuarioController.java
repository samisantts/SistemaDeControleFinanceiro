package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.dto.UsuarioRequestDTO;
import com.example.sistemacontrolefinanceiro.dto.UsuarioResponseDTO;
import com.example.sistemacontrolefinanceiro.mapper.UsuarioMapper;
import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    // POST /usuarios/cadastrar
    @PostMapping("/cadastrar")
    public UsuarioResponseDTO cadastrarUsuario(@RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = usuarioService.cadastrarUsuario(usuario);

        return usuarioMapper.toResponse(salvo);
    }

    // PUT /usuarios/atualizar
    @PutMapping("/atualizar")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }

    // POST /usuarios/login
    @PostMapping("/login")
    public Usuario loginUsuario(@RequestBody Usuario usuario) {
        return usuarioService.loginUsuario(usuario);
    }

    // GET /usuarios/buscar/{id}
    @GetMapping("/buscar/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.listarUsuarioPorId(id);
    }

    // DELETE /usuarios/deletar/{id}
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}
