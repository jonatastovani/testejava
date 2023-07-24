package com.example.testejava.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

//public class CustomRuntimeException extends RuntimeException {
public class CustomRuntimeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

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

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
    
}
