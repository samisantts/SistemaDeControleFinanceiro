package com.example.sistemacontrolefinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(UsuarioJaExisteException.class)
        public ResponseEntity<String> tratarUsuarioJaExiste(UsuarioJaExisteException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }

        @ExceptionHandler(SenhaIncorretaException.class)
        public ResponseEntity<String> tratarSenhaIncorreta(SenhaIncorretaException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        }

        @ExceptionHandler(CategoriaNaoExisteException.class)
        public ResponseEntity<String> tratarCategoriaNaoExiste(CategoriaNaoExisteException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        @ExceptionHandler(UsuarioNaoEncontradoException.class)
        public ResponseEntity<String> tratarUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        @ExceptionHandler(DespesaNaoEncontradaException.class)
        public ResponseEntity<String> tratarDespesaNaoEncontrada(DespesaNaoEncontradaException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }
