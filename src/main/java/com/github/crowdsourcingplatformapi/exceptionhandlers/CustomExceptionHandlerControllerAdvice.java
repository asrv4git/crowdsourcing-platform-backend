package com.github.crowdsourcingplatformapi.exceptionhandlers;

import com.github.crowdsourcingplatformapi.dto.ErrorObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class CustomExceptionHandlerControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorObject> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_FOUND.value(), "No such entity Found");
        return new ResponseEntity(errorObject, HttpStatus.NOT_FOUND);
    }

    //used to throw exceptions from anywhere
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorObject> handleResponseStatusException(ResponseStatusException ex) {
        ErrorObject errorObject = new ErrorObject(ex.getStatus().value(), ex.getReason());
        return ResponseEntity.accepted().body(errorObject);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ErrorObject errorObject = new ErrorObject(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(errorObject);
    }
}
