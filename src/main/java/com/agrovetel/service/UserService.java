package com.agrovetel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.Role;
import com.agrovetel.domain.User;
import com.agrovetel.repository.RoleRepository;
import com.agrovetel.repository.UserRepository;

@Service
public class UserService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private static final String LOGGED_IN_USER = "LOGGED_IN_USER";
	
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private RoleRepository roleRepository;

	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	/**
	 * Finding a user by its id
	 * @param id user id
	 * @return found user
	 */
	public User findById(long id) {
		return this.userRepository.findById(id);
	}
	
	/**
	 * Disable a user
	 * @param id
	 */
	public void disableById(long id) {
		User user = this.userRepository.findById(id);
		user.setEnabled(false);
		this.userRepository.save(user);
	}
	
	/**
	 * Enable a user
	 * @param id
	 */
	public void enableById(long id) {
		User user = this.userRepository.findById(id);
		user.setEnabled(true);
		this.userRepository.save(user);
	}

	/**
	 * Updates a user
	 * @param updatedUser
	 */
	public void updateUser(long id, User updatedUser) {
		User user = this.userRepository.findById(id);
		log.info("User who will be updated: " + user.toString());
		log.info("Updated with: " + updatedUser.toString());
		user.setEmail(updatedUser.getEmail());
		user.setFullname(updatedUser.getFullname());
		this.userRepository.save(updatedUser);
	}

	/**
	 * Register a user
	 * @param user
	 */
	public void registerUser(User user) {
		Role userRole = roleRepository.findByRole(LOGGED_IN_USER);
		if(userRole != null) {
			user.getRoles().add(userRole);
		} else {
			user.addRoles(LOGGED_IN_USER);
		}
		user.setEnabled(true);
		userRepository.save(user);
	}

}
