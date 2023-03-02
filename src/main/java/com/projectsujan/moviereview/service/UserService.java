package com.projectsujan.moviereview.service;

import java.util.List;

import com.projectsujan.moviereview.exception.DuplicateUserNameException;
import com.projectsujan.moviereview.web.dto.UserDTO;
import com.projectsujan.moviereview.web.dto.UserDTO2;

public interface UserService {

	public UserDTO createUser(UserDTO userDTO) throws DuplicateUserNameException;

	public List<UserDTO> getAllUsers();

	public UserDTO getById(Long id);

	public UserDTO updateUser(Long id, UserDTO userDto);

	public String delete(Long id);

	public UserDTO getByUsernameAndPassword(String username, String password);

	public UserDTO getByUsername(String username);

	public UserDTO2 getUserByID(Long id);
}
