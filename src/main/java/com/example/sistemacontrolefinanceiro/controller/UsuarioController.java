package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.dto.UsuarioRequestDTO;
import com.example.sistemacontrolefinanceiro.dto.UsuarioResponseDTO;
import com.example.sistemacontrolefinanceiro.mapper.UsuarioMapper;
import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.service.UsuarioService;
import org.springframework.web.bind.annotation.*;


// Controller: recebe as requisições HTTP e devolve as respostas.
// Não tem regra de negócio, só repassa o trabalho para o service.

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
    //Controle de saida e entrada de dados
    @PostMapping("/cadastrar")
    public UsuarioResponseDTO cadastrarUsuario(@RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = usuarioService.cadastrarUsuario(usuario);

        return usuarioMapper.toResponse(salvo);
    }

    // PUT /usuarios/atualizar
    //Controle de saida e entrada de dados
    @PutMapping("/atualizar")
    public UsuarioResponseDTO atualizarUsuario(@RequestBody UsuarioRequestDTO dto) {
       Usuario usuario = usuarioMapper.toEntity(dto);
       Usuario atualizado = usuarioService.atualizarUsuario(usuario);

       return usuarioMapper.toResponse(atualizado);
    }

    // POST /usuarios/login
    //Controle de saida e entrada de dados
    @PostMapping("/login")
    public UsuarioResponseDTO loginUsuario(@RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario login = usuarioService.loginUsuario(usuario);

        return usuarioMapper.toResponse(login);
    }

    // GET /usuarios/buscar/{id}
    //Controle de saida e entrada de dados
    @GetMapping("/buscar/{id}")
    public UsuarioResponseDTO buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.listarUsuarioPorId(id);
        return usuarioMapper.toResponse(usuario);
    }

    // DELETE /usuarios/deletar/{id}\
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}
