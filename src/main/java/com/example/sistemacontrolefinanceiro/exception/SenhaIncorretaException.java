package com.example.sistemacontrolefinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SenhaIncorretaException extends RuntimeException {
    public SenhaIncorretaException(String message) {
        super("Senha incorreta: " + message);
    }
}
