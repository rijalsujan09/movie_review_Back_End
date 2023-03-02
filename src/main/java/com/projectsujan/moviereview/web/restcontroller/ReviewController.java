package com.projectsujan.moviereview.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectsujan.moviereview.service.MovieReviewService;
import com.projectsujan.moviereview.web.dto.ReviewDTO;

@RestController
@RequestMapping("/api/moviereview")
public class ReviewController {

	@Autowired
	private MovieReviewService reviewService;

	@PostMapping("/review/create")
	public ResponseEntity<ReviewDTO> postReview(@RequestBody ReviewDTO reviewDTO, @RequestParam Long userId,
			@RequestParam Long movieId) {

		ReviewDTO review = this.reviewService.createReview(reviewDTO, movieId, userId);

		return new ResponseEntity<ReviewDTO>(review, HttpStatus.CREATED);

	}

	@DeleteMapping("/review/delete")
	public ResponseEntity<String> deleteReview(@RequestParam Long id) {
		                this.reviewService.deleteReview(id);
		return new ResponseEntity<String>("Review SucessFully Deleted !!", HttpStatus.OK);
	}

}
