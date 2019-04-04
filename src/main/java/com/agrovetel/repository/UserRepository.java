package com.agrovetel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
