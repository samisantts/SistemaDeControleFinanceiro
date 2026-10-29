package com.example.sistemacontrolefinanceiro.mapper;

import com.example.sistemacontrolefinanceiro.dto.UsuarioRequestDTO;
import com.example.sistemacontrolefinanceiro.dto.UsuarioResponseDTO;
import com.example.sistemacontrolefinanceiro.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity (UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        UsuarioResponseDTO resposta = new UsuarioResponseDTO();
        resposta.setId(usuario.getId());
        resposta.setNome(usuario.getNome());
        resposta.setEmail(usuario.getEmail());
        return resposta;

    }
}

