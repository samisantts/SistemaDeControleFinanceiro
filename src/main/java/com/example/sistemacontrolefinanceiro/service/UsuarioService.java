package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        boolean emailJaExistente = usuarioRepository.existsByEmailAndIdNot(usuario.getEmail());
        if (emailJaExistente ) {
            throw new RuntimeException("E-mail ja foi cadastrado");}
        return usuarioRepository.save(usuario);
   }

    public Usuario atualizarUsuario(Usuario usuario) {
        boolean emaiilPertenceAOutroUsuario = usuarioRepository.existsByEmailAndIdNot(usuario.getEmail(), usuario.getId());
        if (emaiilPertenceAOutroUsuario) {
            throw new RuntimeException("E-mail pertence a outro usuario");
        }
        return usuarioRepository.save(usuario);
    }

}
