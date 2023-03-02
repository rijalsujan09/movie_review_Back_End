package com.projectsujan.moviereview.service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsujan.moviereview.entity.Movie;
import com.projectsujan.moviereview.entity.MovieReview;
import com.projectsujan.moviereview.entity.User;
import com.projectsujan.moviereview.exception.ResourceNotFoundException;
import com.projectsujan.moviereview.repository.MovieRepository;
import com.projectsujan.moviereview.repository.MovieReviewRepository;
import com.projectsujan.moviereview.repository.UserRepository;
import com.projectsujan.moviereview.service.MovieReviewService;
import com.projectsujan.moviereview.web.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements MovieReviewService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieReviewRepository reviewRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReviewDTO createReview(ReviewDTO reviewDto, Long movieId, Long userId) {

		Movie movie = this.movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Movie_Id", movieId));
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User_Id", userId));

		MovieReview review = this.modelMapper.map(reviewDto, MovieReview.class);

		review.setMovie(movie);
		review.setReviewer(user);

		review.setCreateDate(new Date());

		MovieReview reviewSaved = this.reviewRepository.save(review);

		return this.modelMapper.map(reviewSaved, ReviewDTO.class);
	}

	@Override
	public void deleteReview(Long Id) {

		MovieReview review = this.reviewRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Review", "Review_Id", Id));

		this.reviewRepository.delete(review);
	}

}
