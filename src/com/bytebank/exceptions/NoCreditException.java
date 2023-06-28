package com.bytebank.exceptions;

public class NoCreditException extends RuntimeException{

	public NoCreditException(String message) {
		super(message);
	}
	
}
