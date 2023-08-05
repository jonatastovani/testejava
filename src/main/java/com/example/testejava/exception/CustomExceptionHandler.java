package com.example.testejava.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<ErrorResponseImpl> handleCustomRuntimeException(CustomRuntimeException ex, WebRequest request) {
        //ErrorResponseImpl errorResponse = new ErrorResponseImpl(ex.getErrorCode(), ex.getMessage(), ex.getHttpStatus().value());
        ErrorResponseImpl errorResponse = new ErrorResponseImpl(ex.getMessage(), ex.getHttpStatus().value());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }
}
