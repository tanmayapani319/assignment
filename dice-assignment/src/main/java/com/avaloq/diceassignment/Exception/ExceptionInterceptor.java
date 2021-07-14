package com.avaloq.diceassignment.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleInputValidationExceptions(
      final ConstraintViolationException ex) {
    final String exceptionResponse = String.format("Invalid input parameters: %s\n", ex.getMessage());
    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoDataFoundExcetion.class)
  public ResponseEntity<Object> handleNoDataFoundExceptions(
    final NoDataFoundExcetion ex
  ) {
    return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }
}
