package com.agrovetel.repository;

import org.springframework.data.repository.CrudRepository;

import com.agrovetel.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
