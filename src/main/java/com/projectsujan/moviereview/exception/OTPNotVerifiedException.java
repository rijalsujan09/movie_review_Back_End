package com.projectsujan.moviereview.exception;

public class OTPNotVerifiedException extends Exception {

	private static final long serialVersionUID = 3442525479961991899L;
	
	String message;

	public OTPNotVerifiedException(String message) {
		super();
		this.message = message;
	}

	public OTPNotVerifiedException() {
		super();
		this.message = "OTP is not verified";
	}
	

}
