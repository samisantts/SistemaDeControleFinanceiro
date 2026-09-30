package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        boolean emailJaExistente = usuarioRepository.existsByEmail(usuario.getEmail());
         if (emailJaExistente == true) {
            throw new RuntimeException("E-mail ja foi cadastrado");
        } else {
            return usuarioRepository.salvarUsuario(usuario);
        }
    }
}