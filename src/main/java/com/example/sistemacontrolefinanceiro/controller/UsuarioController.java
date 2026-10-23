package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.dto.UsuarioRequestDTO;
import com.example.sistemacontrolefinanceiro.dto.UsuarioResponseDTO;
import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final  UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/usuarios")

    public UsuarioResponseDTO cadastrar(@RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        Usuario salvo = usuarioService.cadastrarUsuario(usuario);

        UsuarioResponseDTO resposta = new UsuarioResponseDTO();
        resposta.setId(salvo.getId());
        resposta.setNome(salvo.getNome());
        resposta.setEmail(salvo.getEmail());

        return resposta;
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







