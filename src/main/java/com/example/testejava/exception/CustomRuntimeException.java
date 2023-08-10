package com.example.testejava.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class CustomRuntimeException extends RuntimeException {
    private String errorCode;
    private HttpStatus httpStatus;

    public CustomRuntimeException(String errorCode, String message, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
