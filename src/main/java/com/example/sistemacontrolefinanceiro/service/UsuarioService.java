package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        boolean emailJaExistente = usuarioRepository.existsByEmail(usuario.getEmail());
        if (emailJaExistente) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail ja foi cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {

        boolean usuarioExiste = usuarioRepository.existsById(usuario.getId());
        if (!usuarioExiste) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado");
        }
        boolean emailPertenceAOutroUsuario = usuarioRepository.existsByEmailAndIdNot(usuario.getEmail(), usuario.getId());
        if (emailPertenceAOutroUsuario) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail pertence a outro usuario");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario loginUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioEncontrado == null) {
        }
        if (usuario.getSenha().equals(usuarioEncontrado.getSenha())) {
            return usuarioEncontrado;
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Senha incorreta");
    }

    public void deletarUsuario(Long id) {
        boolean usuarioExiste = usuarioRepository.existsById(id);
        if (!usuarioExiste) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id nao encontrado");
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
