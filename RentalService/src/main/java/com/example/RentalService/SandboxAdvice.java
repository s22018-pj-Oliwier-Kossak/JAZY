package com.example.RentalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class SandboxAdvice extends RuntimeException{


    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<String> HandlerRuntimeExecption(HttpClientErrorException exception) {
       // ResponseEntity<String> q=null;
        switch (exception.getStatusCode()){
            case INTERNAL_SERVER_ERROR :
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception thorw: 500" );
            case  NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception thorw: 500" );
            case BAD_REQUEST:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception thorw: 500" );
            case NO_CONTENT:
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Exception thorw: 500" );
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception thorw: 500" );

    }
    @ExceptionHandler(ConnectException.class)
    ResponseEntity<String> Con(ConnectException exception) {
      return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("No connect" );

    }



}
