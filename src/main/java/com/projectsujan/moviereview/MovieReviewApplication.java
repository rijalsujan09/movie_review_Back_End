package com.projectsujan.moviereview;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieReviewApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MovieReviewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewApplication.class, args);

		logger.info("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
	}

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}
	


	@Override
	public void run(String... args) throws Exception {

	}

}
