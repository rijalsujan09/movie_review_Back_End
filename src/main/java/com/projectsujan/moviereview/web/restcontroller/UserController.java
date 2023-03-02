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

import com.projectsujan.moviereview.exception.DuplicateUserNameException;
import com.projectsujan.moviereview.service.UserService;
import com.projectsujan.moviereview.service.impl.UserServiceImpl;
import com.projectsujan.moviereview.web.dto.UserDTO;
import com.projectsujan.moviereview.web.dto.UserDTO2;

@RestController
@RequestMapping("/api/moviereview")
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping("/check")
	public ResponseEntity<String> checkConnection() {
		return new ResponseEntity<String>("Server Running Sucesfully", HttpStatus.OK);
	}

	@PostMapping("/user/createuser")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws DuplicateUserNameException {
		UserDTO createdUser = this.userService.createUser(userDTO);
		return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("/user")
	public ResponseEntity<UserDTO> getUser(@RequestParam Long id) {
		

		UserDTO user = this.userService.getById(id);

		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);

	}

	@GetMapping("user/userlist")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		List<UserDTO> userList = this.userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(userList, HttpStatus.OK);
	}

	@PutMapping("user/update/{id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
		UserDTO updatedUser = this.userService.updateUser(id, userDTO);
		return new ResponseEntity<UserDTO>(updatedUser, HttpStatus.OK);

	}

	@DeleteMapping("user/delete")
	public ResponseEntity<String> deleteUser(@RequestParam Long id) {

		this.userService.delete(id);

		return new ResponseEntity<String>("User Deleted Sucessfull !!", HttpStatus.OK);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO2> getUserById(@PathVariable Long id) {

		UserDTO2 userDTO2 = this.userService.getUserByID(id);

		return new ResponseEntity<UserDTO2>(userDTO2, HttpStatus.OK);

	}

}
