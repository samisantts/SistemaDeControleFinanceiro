package com.example.sistemacontrolefinanceiro.dto;

import com.example.sistemacontrolefinanceiro.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseDTO {

    private long id;
    private String nome;
    private String email;


}
