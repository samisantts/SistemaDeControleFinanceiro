package com.example.sistemacontrolefinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoriaNaoExisteException extends RuntimeException {
    public CategoriaNaoExisteException(String message) {
        super("Categoria nao existe" + message);
    }
}
