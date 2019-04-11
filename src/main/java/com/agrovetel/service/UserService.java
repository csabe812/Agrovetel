package com.agrovetel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovetel.domain.User;
import com.agrovetel.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	public void deleteById(long id) {
		this.userRepository.deleteById(id);
	}

}
