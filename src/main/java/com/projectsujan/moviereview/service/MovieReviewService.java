package com.projectsujan.moviereview.service;

import com.projectsujan.moviereview.web.dto.ReviewDTO;

public interface MovieReviewService {

	ReviewDTO createReview(ReviewDTO reviewDto, Long movieId, Long userId);

	public void deleteReview(Long Id) ;

}
