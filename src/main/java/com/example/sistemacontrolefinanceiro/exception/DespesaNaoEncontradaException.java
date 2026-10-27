package com.example.sistemacontrolefinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DespesaNaoEncontradaException extends RuntimeException {
    public DespesaNaoEncontradaException(String message) {
        super("Despesa nao encontrada" + message);
    }
}
