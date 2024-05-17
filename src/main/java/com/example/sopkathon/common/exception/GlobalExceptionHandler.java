package com.example.sopkathon.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorStatusResponse> customException(CustomException e) {
        return ResponseEntity.status(e.getErrorMessage().getStatus())
                .body(e.toErrorResponse());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorStatusResponse> globalException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorStatusResponse.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }
}
