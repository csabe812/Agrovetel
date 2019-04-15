package com.agrovetel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findById(long id);
	Role findByRole(String role);
	
}
