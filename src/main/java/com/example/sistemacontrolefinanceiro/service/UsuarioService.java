package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.mapper.UsuarioMapper;
import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        boolean emailJaExistente = usuarioRepository.existsByEmail(usuario.getEmail());
        if (emailJaExistente) {
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {

        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        boolean usuarioExiste = usuarioRepository.existsById(usuario.getId());
        if (!usuarioExiste) {
        }
        boolean emailPertenceAOutroUsuario = usuarioRepository.existsByEmailAndIdNot(usuario.getEmail(), usuario.getId());
        if (emailPertenceAOutroUsuario) {
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario loginUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioEncontrado == null) {
        } else if (usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
            return usuarioEncontrado;
        } else {
            return null;
        }
        return usuarioEncontrado;
    }

    public void deletarUsuario(Long id) {
        boolean usuarioExiste = usuarioRepository.existsById(id);
        if (!usuarioExiste) {
        }
        usuarioRepository.deleteById(id);
    }
    public Usuario listarUsuarioPorId(Long id) {
        boolean usuarioExiste = usuarioRepository.existsById(id);
        if (!usuarioExiste) {
        }
        return usuarioRepository.findById(id).get();
    }
}
