package com.example.testejava.model.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> errorMessages = ex.getBindingResult()
                                      .getFieldErrors()
                                      .stream()
                                      .map(error -> error.getDefaultMessage())
                                      .collect(Collectors.toList());

        String errorMessage = "Erro(s) de validação nos campos: " + String.join(", ", errorMessages);

        ErrorResponse errorResponse = new ErrorResponse("VALIDATION_ERROR", HttpStatus.BAD_REQUEST, errorMessage, errorMessages);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
