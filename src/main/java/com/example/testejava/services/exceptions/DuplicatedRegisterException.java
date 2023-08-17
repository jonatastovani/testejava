package com.example.testejava.services.exceptions;

public class DuplicatedRegisterException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicatedRegisterException (String msg) {
		super(msg);
	}
}