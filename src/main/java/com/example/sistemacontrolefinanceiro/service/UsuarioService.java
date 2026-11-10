package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.exception.SenhaIncorretaException;
import com.example.sistemacontrolefinanceiro.exception.UsuarioJaExisteException;
import com.example.sistemacontrolefinanceiro.exception.UsuarioNaoEncontradoException;
import com.example.sistemacontrolefinanceiro.mapper.UsuarioMapper;
import com.example.sistemacontrolefinanceiro.model.Usuario;
import com.example.sistemacontrolefinanceiro.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


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
            throw new UsuarioJaExisteException("E-mail já cadastrado!");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A senha não pode ser vazia!");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        boolean usuarioExiste = usuarioRepository.existsById(usuario.getId());
        if (!usuarioExiste) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        }

        boolean emailPertenceAOutroUsuario = usuarioRepository.existsByEmailAndIdNot(usuario.getEmail(), usuario.getId());
        if (emailPertenceAOutroUsuario) {
            throw new UsuarioJaExisteException("E-mail já pertence a outro usuário!");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario loginUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioEncontrado == null) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        } else if (usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
            return usuarioEncontrado;
        } else {
            throw new SenhaIncorretaException("Senha incorreta!");
        }
    }

    public void deletarUsuario(Long id) {
        boolean usuarioExiste = usuarioRepository.existsById(id);
        if (!usuarioExiste) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario listarUsuarioPorId(Long id) {
        boolean usuarioExiste = usuarioRepository.existsById(id);
        if (!usuarioExiste) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        }
        return usuarioRepository.findById(id).get();
    }

}