package com.github.crowdsourcingplatformapi.exceptionhandlers;

import com.github.crowdsourcingplatformapi.dto.ErrorObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ExceptionHandlerControllerAdvice {

    Logger log = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorObject> handleEntityNotFound(EntityNotFoundException ex) {
        log.error(ex.getMessage());
        ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_FOUND.value(), ApiErrorResponseUtil.getErrorResponseMessage(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity(errorObject, HttpStatus.NOT_FOUND);
    }

    //used to throw exceptions from anywhere
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorObject> handleResponseStatusException(ResponseStatusException ex) {
        String message = ApiErrorResponseUtil.getErrorResponseMessage(ex.getStatus().value()) != null ?
                ApiErrorResponseUtil.getErrorResponseMessage(ex.getStatus().value()) : ex.getMessage();
        log.error(ex.getMessage());
        ErrorObject errorObject = new ErrorObject(ex.getStatus().value(), message);
        return ResponseEntity.accepted().body(errorObject);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage());
        ErrorObject errorObject = new ErrorObject(HttpStatus.BAD_REQUEST.value(), ApiErrorResponseUtil.getErrorResponseMessage(HttpStatus.BAD_REQUEST.value()));
        return ResponseEntity.badRequest().body(errorObject);
    }
}
