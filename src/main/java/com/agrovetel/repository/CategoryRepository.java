package com.agrovetel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agrovetel.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Category findById(long id);
	List<Category> findAll();
	void deleteById(long id);
	
}
