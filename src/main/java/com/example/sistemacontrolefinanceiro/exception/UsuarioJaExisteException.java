package com.example.sistemacontrolefinanceiro.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioJaExisteException extends RuntimeException {
    public UsuarioJaExisteException(String message) {
        super("E-mail ja foi cadastrado" + message);
    }

}
