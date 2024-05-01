package com.workintech.spring17challenge.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<com.workintech.spring17challenge.exceptions.ApiErrorResponse> handleApiException(com.workintech.spring17challenge.exceptions.ApiException exception) {
        log.error("apiexception occured! Exception details: ", exception.getMessage());
        com.workintech.spring17challenge.exceptions.ApiErrorResponse apiErrorResponse = new com.workintech.spring17challenge.exceptions.ApiErrorResponse(exception.getHttpStatus().value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(apiErrorResponse, exception.getHttpStatus());

    }

    @ExceptionHandler
    public ResponseEntity<com.workintech.spring17challenge.exceptions.ApiErrorResponse> handleException(Exception exception) {
        log.error("apiexception occured! Exception details: ", exception.getMessage());
        com.workintech.spring17challenge.exceptions.ApiErrorResponse apiErrorResponse = new com.workintech.spring17challenge.exceptions.ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
