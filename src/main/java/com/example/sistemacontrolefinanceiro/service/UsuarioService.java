package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        boolean emailJaExistente = usuarioRepository.existsByEmail(usuario.getEmail());
        if (emailJaExistente) {
            throw new RuntimeException("E-mail ja foi cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        boolean emailPertenceAOutroUsuario = usuarioRepository.existsByEmailAndIdNot(usuario.getEmail(), usuario.getId());
        if (emailPertenceAOutroUsuario) {
            throw new RuntimeException("E-mail pertence a outro usuario");
        }

        boolean usuarioExiste = usuarioRepository.existsById(usuario.getId());
        if (!usuarioExiste) {
            throw new RuntimeException("Usuario nao encontrado");
        }

        return usuarioRepository.save(usuario);
    }

}