package com.projectsujan.moviereview.service;

import java.util.List;

import com.projectsujan.moviereview.web.dto.MovieDTO;

public interface MovieService {

	MovieDTO createMovie(MovieDTO movieDTO, Long userId, Long categoryId);

	List<MovieDTO> getMovieList();

	MovieDTO getMovieById(Long id);

	MovieDTO updateMoveie(Long id, MovieDTO movieDTO);

	void deleteMovie(Long id);

}
