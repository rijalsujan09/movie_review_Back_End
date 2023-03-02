package com.projectsujan.moviereview.service;

public interface EmailServce {

	 String sendMail(String userEmail, String username);
	 
	 String sendOtpMail(String userEmail, String username, String otp);
}
