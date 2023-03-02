package com.projectsujan.moviereview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.projectsujan.moviereview.service.EmailServce;

@Service
public class EmailServiceImpl implements EmailServce {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private static String sender;

	@Override
	public String sendMail(String userEmail, String username) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userEmail);
		message.setFrom(sender);
		message.setSubject("Welcome EMAIL!!!");

		String welcomeMessage = "Hello, " + username
				+ "  Welcome to Movie Review Application. Start adding reviews to movies";

		message.setText(welcomeMessage);

		javaMailSender.send(message);

		return "Successfull";
	}

	@Override
	public String sendOtpMail(String userEmail, String username, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userEmail);
		message.setFrom(sender);
		message.setSubject("Welcome EMAIL!!!");

		String welcomeMessage = "Hello, " + username + ". Welcome to Movie Review Application. Your otp is " + otp
				+ ".";

		message.setText(welcomeMessage);

		javaMailSender.send(message);

		return "Successfull";

	}

}
