package com.bookyourbook.exception;

public class BookYourBookException extends Exception{

	private static final long serialVersionUID = -5465086918919378791L;

	public BookYourBookException() {
		super();
	}
	public BookYourBookException(String message, Throwable cause) {
        super(message, cause);
        
    }

    public BookYourBookException(String message) {
        super(message);
        
    }

    public BookYourBookException(Throwable cause) {
        super(cause);
        
    }

}
