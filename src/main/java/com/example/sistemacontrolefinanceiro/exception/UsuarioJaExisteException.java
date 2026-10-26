package com.example.sistemacontrolefinanceiro.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus

public class UsuarioJaExisteException extends RuntimeException {
}
