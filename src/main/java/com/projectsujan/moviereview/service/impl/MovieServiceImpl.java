package com.projectsujan.moviereview.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsujan.moviereview.entity.Category;
import com.projectsujan.moviereview.entity.Movie;
import com.projectsujan.moviereview.entity.User;
import com.projectsujan.moviereview.exception.ResourceNotFoundException;
import com.projectsujan.moviereview.repository.CategoryRepository;
import com.projectsujan.moviereview.repository.MovieRepository;
import com.projectsujan.moviereview.repository.UserRepository;
import com.projectsujan.moviereview.service.MovieService;
import com.projectsujan.moviereview.web.dto.MovieDTO;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public MovieDTO createMovie(MovieDTO movieDTO, Long userId, Long categoryId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User_Id", userId));

		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User_Id", categoryId));

		Movie movie = this.modelMapper.map(movieDTO, Movie.class);

		movie.setCategory(category);
		movie.setUser(user);

		Movie createdMovie = this.movieRepository.save(movie);

		return this.modelMapper.map(createdMovie, MovieDTO.class);
	}

	@Override
	public List<MovieDTO> getMovieList() {

		List<Movie> movies = this.movieRepository.findAll();

		List<MovieDTO> movieList = movies.stream().map((movie) -> this.modelMapper.map(movie, MovieDTO.class))
				.collect(Collectors.toList());

		return movieList;
	}

	@Override
	public MovieDTO getMovieById(Long id) {

		Movie movie = this.movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Movie_Id", id));

		MovieDTO movieDTO = this.modelMapper.map(movie, MovieDTO.class);

		return movieDTO;
	}

	@Override
	public MovieDTO updateMoveie(Long id, MovieDTO movieDTO) {

		Movie movie = this.movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Movie_Id", id));

		movie.setName(movieDTO.getName());
		movie.setSynopsis(movieDTO.getSynopsis());
		movie.setActive(movieDTO.getActive());
		movie.setBudget(movieDTO.getBudget());

		Movie updatedMovie = this.movieRepository.save(movie);

		return this.modelMapper.map(updatedMovie, MovieDTO.class);
	}

	@Override
	public void deleteMovie(Long id) {

		Movie movie = this.movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Movie_Id", id));
		this.movieRepository.delete(movie);
	}

}
