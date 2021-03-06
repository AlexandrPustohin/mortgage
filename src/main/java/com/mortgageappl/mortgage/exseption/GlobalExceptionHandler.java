package com.mortgageappl.mortgage.exseption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> globalHttpMessageNotReadableException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Проверьте сумму и срок в заявке", "HttpMessageNotReadableException");
        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MismatchCheckException.class)
    public ResponseEntity<ErrorDetails>   mismatchCheckException(MismatchCheckException ex) {
        ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), "MismatchCheckException");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
