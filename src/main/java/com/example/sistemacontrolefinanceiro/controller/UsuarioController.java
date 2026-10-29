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

    private UsuarioService usuarioService;
    private UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //O JSON chega e o @RequestBody vira um UsuarioRequestDTO.
    //O controller chama usuarioMapper.toEntity(dto) e recebe um Usuario.
    //O service recebe esse Usuario, aplica as regras e salva.
    //O controller pega o Usuario salvo, chama usuarioMapper.toResponse(salvo) e devolve o DTO.

    @PostMapping
    public UsuarioResponseDTO cadastrar(@RequestBody UsuarioRequestDTO dto){
        Usuario salvo = usuarioService.cadastrarUsuario(usuarioMapper.toEntity(dto));
        return usuarioMapper.toResponse(salvo);
    }

    @PutMapping
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return usuarioService.loginUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.listarUsuarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}



