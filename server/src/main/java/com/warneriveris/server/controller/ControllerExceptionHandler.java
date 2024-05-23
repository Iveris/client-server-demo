package com.warneriveris.server.controller;

import com.warneriveris.server.exception.ObjectValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<?> handleException(ObjectValidationException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getErrorMessages());
    }

}
