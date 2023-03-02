package com.projectsujan.moviereview.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectsujan.moviereview.service.MovieService;
import com.projectsujan.moviereview.web.dto.MovieDTO;

@RestController
@RequestMapping("/api/moviereview")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/movie/create")
	public ResponseEntity<MovieDTO> createUser(@RequestBody MovieDTO movieDTO, @RequestParam Long userId,
			@RequestParam Long categoryId) {

		MovieDTO createdMovie = this.movieService.createMovie(movieDTO, userId, categoryId);

		return new ResponseEntity<MovieDTO>(createdMovie, HttpStatus.CREATED);
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {

		MovieDTO movieDTO = this.movieService.getMovieById(id);

		return new ResponseEntity<MovieDTO>(movieDTO, HttpStatus.OK);
	}

	@PutMapping("/movie/update")
	public ResponseEntity<MovieDTO> upDateMovie(@RequestParam Long id, @RequestBody MovieDTO movieDTO) {

		MovieDTO updatedMovie = this.movieService.updateMoveie(id, movieDTO);

		return new ResponseEntity<MovieDTO>(updatedMovie, HttpStatus.OK);

	}

	@GetMapping("/movie/list")
	public ResponseEntity<List<MovieDTO>> getMovieList() {
		List<MovieDTO> movieList = this.movieService.getMovieList();

		return new ResponseEntity<List<MovieDTO>>(movieList, HttpStatus.OK);
	}
	
	@DeleteMapping("/movie/delete")
	public ResponseEntity<String> deleteMovie(@RequestParam Long id){
		
		this.movieService.deleteMovie(id);
		return new ResponseEntity<String>("Movie Deleted Sucessfully !!" ,HttpStatus.OK);
	}

}
