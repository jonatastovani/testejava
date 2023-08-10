package com.example.testejava.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String cause = null;
    private String errorCode;
    private String httpStatus;
    private String message;
    private String[] suppressed = null;
    private String localizedMessage;

    public ErrorResponse(String errorCode, HttpStatus httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus.toString();
        this.message = message;
        this.localizedMessage = message;
    }

    public String getCause() {
        return cause;
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

    public String[] getSuppressed() {
        return suppressed;
    }

    public String getLocalizedMessage() {
        return localizedMessage;
    }
}
