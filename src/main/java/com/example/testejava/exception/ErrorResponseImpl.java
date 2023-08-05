package com.example.testejava.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

public class ErrorResponseImpl implements ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private int httpStatus;

    public ErrorResponseImpl(String errorMessage, int httpStatus) {
        //this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public HttpStatusCode getStatusCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProblemDetail getBody() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
