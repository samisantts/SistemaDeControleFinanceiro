package com.example.sistemacontrolefinanceiro.repository;

import com.example.sistemacontrolefinanceiro.model.Usuario;

public class UsuarioRepository {

    public boolean existsByEmail(String email) {

        return false;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuario;
    }

}