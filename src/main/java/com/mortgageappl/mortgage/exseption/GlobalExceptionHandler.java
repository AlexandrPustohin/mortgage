package com.mortgageappl.mortgage.exseption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails>   resourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), "ResourceNotFoundException");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "хрень от сюда  "+ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MissmachCheckExeption.class)
    public ResponseEntity<ErrorDetails>   missmachCheckExeption(MissmachCheckExeption ex) {
        ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), "MissmachCheckExeption");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}