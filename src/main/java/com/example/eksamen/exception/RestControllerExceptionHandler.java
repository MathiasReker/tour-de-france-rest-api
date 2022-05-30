package com.example.eksamen.exception;

import com.example.eksamen.payload.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {

    return new ResponseEntity<>(
        new ApiError(LocalDateTime.now(), "Resourcen blev ikke fundet.", ex.getMessage()),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleAll(Exception ex) {

    return new ResponseEntity<>(
        new ApiError(LocalDateTime.now(), "Der opstod en fejl.", ex.getMessage()),
        HttpStatus.BAD_REQUEST);
  }
}
