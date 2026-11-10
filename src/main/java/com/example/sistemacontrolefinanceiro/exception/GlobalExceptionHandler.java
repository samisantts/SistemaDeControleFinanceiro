package com.example.sistemacontrolefinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

            @ExceptionHandler(UsuarioJaExisteException.class)
            public ResponseEntity<String> tratarUsuarioJaExiste(UsuarioJaExisteException e) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(e.getMessage());
            }

            @ExceptionHandler(UsuarioNaoEncontradoException.class)
            public ResponseEntity<String> tratarUsuarioNaoEncontrado(UsuarioNaoEncontradoException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(e.getMessage());
            }

            @ExceptionHandler(SenhaIncorretaException.class)
            public ResponseEntity<String> tratarSenhaIncorreta(SenhaIncorretaException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(e.getMessage());
            }

            @ExceptionHandler(CategoriaNaoExisteException.class)
            public ResponseEntity<String> tratarCategoriaNaoExiste(CategoriaNaoExisteException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(e.getMessage());
            }
        }
