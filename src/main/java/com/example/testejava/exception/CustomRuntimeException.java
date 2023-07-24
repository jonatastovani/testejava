package com.example.testejava.exception;

import org.springframework.http.HttpStatus;

public class CustomRuntimeException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus status;

    public CustomRuntimeException(String errorCode, String message, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
