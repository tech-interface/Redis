package com.techinterface.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity("record not found", HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> genericException(Exception exception) {
        ApiException apiError =
                new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, exception);
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());

    }


}