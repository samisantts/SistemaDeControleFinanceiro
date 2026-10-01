package com.example.sistemacontrolefinanceiro.repository;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmailAndIdNot(String email, Long id);
    boolean existsByEmail(String email);
}