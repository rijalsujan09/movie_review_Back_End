package com.projectsujan.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.moviereview.entity.MovieReview;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {

}
