package com.example.sistemacontrolefinanceiro.exception;

public class SenhaIncorretaException extends RuntimeException {
    public SenhaIncorretaException(String message) {
        super("Senha incorreta: " + message);
    }
}
