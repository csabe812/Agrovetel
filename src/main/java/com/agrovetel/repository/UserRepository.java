package com.agrovetel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findById(long id);
	List<User> findAll();
}
