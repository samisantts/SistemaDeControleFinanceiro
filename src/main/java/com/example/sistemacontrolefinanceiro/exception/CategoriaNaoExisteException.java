package com.example.sistemacontrolefinanceiro.exception;

public class CategoriaNaoExisteException extends RuntimeException {
    public CategoriaNaoExisteException(String message) {
        super("Categoria nao existe" + message);
    }
}
