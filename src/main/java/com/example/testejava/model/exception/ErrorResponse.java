package com.example.testejava.model.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ErrorResponse {
    private String errorCode;
    private String httpStatus;
    private String message;
    private List<String> errors;

    public ErrorResponse(String errorCode, HttpStatus httpStatus, String message, List<String> errors) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus.toString();
        this.message = message;
        this.errors = errors;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}
