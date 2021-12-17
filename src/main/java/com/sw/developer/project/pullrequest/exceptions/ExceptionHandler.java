package com.sw.developer.project.pullrequest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handle(Exception exception){

        return new ResponseEntity<>(new ApiException(exception.getMessage(), HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);

    }

}
