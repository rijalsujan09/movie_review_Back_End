package com.projectsujan.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.moviereview.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
