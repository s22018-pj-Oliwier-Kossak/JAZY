package com.example.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SandboxAdvice extends RuntimeException{


    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> HandlerRuntimeExecption(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception thorw: 404" );
    }


}
