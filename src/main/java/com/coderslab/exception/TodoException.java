package com.coderslab.exception;
/**
 * @author cyclingbd007
 *
 */
public class TodoException extends Exception {

	public TodoException() {
		super();
	}

	public TodoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TodoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TodoException(String message) {
		super(message);
	}

	public TodoException(Throwable cause) {
		super(cause);
	}

}
