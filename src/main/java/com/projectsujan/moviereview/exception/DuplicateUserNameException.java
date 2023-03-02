package com.projectsujan.moviereview.exception;

public class DuplicateUserNameException extends Exception {
	
	private static final long serialVersionUID = -8986383964897501791L;
	
	private String message;
	
	public DuplicateUserNameException(String message) {
		super();
		this.message = message;
	}
	
	public DuplicateUserNameException() {
		super();
		this.message = "Username already exists";
	}


}
