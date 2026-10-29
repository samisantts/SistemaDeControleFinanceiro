package com.example.sistemacontrolefinanceiro.mapper;

import com.example.sistemacontrolefinanceiro.dto.UsuarioRequestDTO;
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
    public UsuarioRequestDTO toResponse (Usuario usuario) {
        UsuarioRequestDTO Resposta = new UsuarioRequestDTO();
        Resposta.setNome(usuario.getNome());
        Resposta.setEmail(usuario.getEmail());
        Resposta.setSenha(usuario.getSenha());
        return Resposta;

    }
}
