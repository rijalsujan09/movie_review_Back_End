package com.projectsujan.moviereview.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsujan.moviereview.entity.User;
import com.projectsujan.moviereview.exception.DuplicateUserNameException;
import com.projectsujan.moviereview.exception.OTPNotVerifiedException;
import com.projectsujan.moviereview.exception.ResourceNotFoundException;
import com.projectsujan.moviereview.repository.UserRepository;
import com.projectsujan.moviereview.service.OTPService;
import com.projectsujan.moviereview.service.UserService;
import com.projectsujan.moviereview.web.dto.UserDTO;
import com.projectsujan.moviereview.web.dto.UserDTO2;

@Service
public class UserServiceImpl implements UserService {

//	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OTPService otpService;

	@Autowired
	private ModelMapper modelMapper;

	public UserDTO createUser(UserDTO userDTO) throws DuplicateUserNameException {

		User user = this.modelMapper.map(userDTO, User.class);

		user.setPassword(userDTO.getPassword());

		User savedUser = this.userRepository.save(user);

		return this.userToDto(savedUser);
	}

	public List<UserDTO> getAllUsers() {

		List<User> users = this.userRepository.findAll();

		List<UserDTO> userDTOs = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDTOs;
	}

	public UserDTO getById(Long id) {

		User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		return this.userToDto(user);
	}

	public UserDTO updateUser(Long id, UserDTO userDto) {

		User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setActive(true);
		User updatedUser = this.userRepository.save(user);
		UserDTO userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	public String delete(Long id) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		this.userRepository.delete(user);
		return "User with id : " + id + " Sucessfully Deleted !";
	}

	public UserDTO getByUsernameAndPassword(String username, String password) {

		User user = this.userRepository.findByUsernameAndPassword(username, password);

		UserDTO userDTO = this.userToDto(user);

		return userDTO;
	}

	public UserDTO verifyOtp(UserDTO userDTO) throws OTPNotVerifiedException {

		return null;
	}

	@Override
	public UserDTO getByUsername(String username) {

		User user = this.userRepository.findByUsername(username);

		UserDTO userDTO = this.userToDto(user);

		return userDTO;
	}

	// to convert DTO to user
	private User dtoToUser(UserDTO userDTO) {

		User user = this.modelMapper.map(userDTO, User.class);

		return user;
	}

	// to convert user to DTO
	private UserDTO userToDto(User user) {

		UserDTO userDto = this.modelMapper.map(user, UserDTO.class);

		return userDto;
	}

	@Override
	public UserDTO2 getUserByID(Long id) {

		User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		return this.modelMapper.map(user, UserDTO2.class);

	}

}
