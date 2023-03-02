package com.projectsujan.moviereview.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.projectsujan.moviereview.service.OTPService;
@Service
public class OTPServiceImpl implements OTPService {

	public String generateOTP() {
		Integer number =  100000 + new Random().nextInt(900000);
		return String.valueOf(number);
	}
 


}